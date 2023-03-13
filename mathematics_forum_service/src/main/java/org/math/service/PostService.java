package org.math.service;

import org.math.entity.Comment;
import org.math.entity.Post;
import org.math.response.PostVo;

import java.time.LocalDateTime;
import java.util.List;


/**
 * @Description: Post Service 层
 * @Author: Cauchy
 * @CreateTime: 2022/10/6
 */
public interface PostService {
    /**
     * 获取热度排名前 20 的热帖
     *
     * @return List<PostVo>
     */
    List<PostVo> getTop20HotPost();

    /**
     * 获取热度
     *
     * @param createTime 创建时间
     * @param comments   评论数
     * @param like       点赞数
     * @return 热度
     */
    int getHotDegree(LocalDateTime createTime, int comments, int like, int scan);

    /**
     * 热门榜单存储设计
     */
    void synchronizeHotList();

    List<Post> getHotList();

    void addComment(Comment comment);

    void addLike(long postId);
}
