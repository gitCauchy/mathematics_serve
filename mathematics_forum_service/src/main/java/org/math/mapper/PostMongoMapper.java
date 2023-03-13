package org.math.mapper;

import org.math.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface PostMongoMapper extends MongoRepository<Post, Long> {

    /**
     * 热榜
     *
     * @return List<Post>
     */
    @Query("find({}).sort({hotDegree : -1}).limit(20)")
    List<Post> findTop20HotPosts();
}
