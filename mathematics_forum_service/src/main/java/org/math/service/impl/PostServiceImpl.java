package org.math.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.math.entity.Comment;
import org.math.entity.HotListRecord;
import org.math.entity.Post;
import org.math.mapper.PostMongoMapper;
import org.math.mapper.PostMySQLMapper;
import org.math.response.CommentVo;
import org.math.response.PostVo;
import org.math.service.HotListRecordService;
import org.math.service.PostService;
import org.math.utils.RedisUtil;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Description: Post Service 实现类
 * @Author: Cauchy
 * @CreateTime: 2022/10/6
 */
@Service
@AllArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {

    PostMySQLMapper postMySQLMapper;

    PostMongoMapper postMongoMapper;

    HotListRecordService hotListRecordService;

    RedisUtil redisUtil;

    MongoTemplate mongoTemplate;

    @Override
    public List<PostVo> getTop20HotPost() {

//        List<Post> topPosts = postMongoMapper.findTop20HotPosts();
        Query query = new Query();
        query.with(Sort.by(Sort.Order.desc("hotDegree")));
        List<Post> topPosts = mongoTemplate.find(query, Post.class);

        List<PostVo> postVoList = new ArrayList<>();
        topPosts.forEach(post -> {
            PostVo postVo = new PostVo();
            postVo.setId(post.getId());
            postVo.setAuthor(post.getAuthor());
            postVo.setContent(post.getContent());
            postVo.setLike(post.getLike());
            postVo.setTitle(post.getTitle());
            List<CommentVo> commentVos = new ArrayList<>();
            List<Comment> comments = post.getComments();
            comments.forEach(comment -> {
                CommentVo commentVo = new CommentVo();
                commentVo.setAuthor(comment.getAuthor());
                commentVo.setLike(comment.getLike());
                commentVo.setContent(comment.getContent());
                commentVos.add(commentVo);
            });
            postVo.setComments(commentVos);
            postVoList.add(postVo);
        });
        return postVoList;
    }

    @Override
    public int getHotDegree(LocalDateTime createTime, int comments, int like, int scan) {
        LocalDate now = LocalDate.now();
        int distance = Period.between(now, createTime.toLocalDate()).getDays();
        return (scan + 2 * distance * like + 3 * distance * comments);
    }

    @Override
    public void synchronizeHotList() {
        List<Post> topPosts = postMongoMapper.findTop20HotPosts();
        topPosts.forEach(post -> {
            String key = "post_" + post.getId().toString();
            redisUtil.put(key, "author", post.getAuthor());
            redisUtil.put(key, "like", post.getLike());
            redisUtil.put(key, "content", post.getContent());
            redisUtil.put(key, "title", post.getTitle());
            redisUtil.put(key, "scan", post.getScan());
            redisUtil.put(key, "createTime", post.getCreateTime());
        });
    }

    @Override
    public List<Post> getHotList() {
        List<Post> hostList = new ArrayList<>();
        String hotIdList = redisUtil.get(LocalDate.now().toString());
        // 22|33|44|55|66|
        String[] ids = hotIdList.split("\\|");
        List<Post> postList = new ArrayList<>();
        // 从 redis 中取出热榜数据
        for (String id : ids) {
            // key : post_id
            Map<Object, Object> postMap = redisUtil.entries("post_" + id);
            Post post = new Post();
            post.setAuthor((String) postMap.get("author"));
            post.setContent((String) postMap.get("content"));
            post.setTitle((String) postMap.get("title"));
            post.setLike((int) postMap.get("like"));
            post.setScan((int) postMap.get("scan"));
            post.setCreateTime((LocalDateTime) postMap.get("createTime"));
            post.setId(Long.valueOf(id));
            postList.add(post);
        }
        return postList;
    }

    @Override
    public void addComment(Comment comment) {
        Optional<Post> postOptional = postMongoMapper.findById(comment.getPostId());
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            post.getComments().add(comment);
//            postMongoMapper.save(post);
            mongoTemplate.insert(post
            );
        }

    }

    @Override
    public void addLike(long postId) {
        Optional<Post> postOptional = postMongoMapper.findById(postId);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            post.setLike(post.getLike() + 1);
            postMongoMapper.save(post);
        }
    }

    /**
     * 保存 Post 热榜 Id 持久化到 MySQL 中
     */
    private void saveHotIdList(List<Post> topPosts) {
        StringBuilder sb = new StringBuilder();
        topPosts.forEach(post -> {
            sb.append(post.getId());
            sb.append("|");
        });
        HotListRecord hotListRecord = new HotListRecord();
        hotListRecord.setDate(LocalDate.now());
        hotListRecord.setHotIdList(sb.toString());
        // TODO save hotListRecordService.save(hotListRecord);
    }
}
