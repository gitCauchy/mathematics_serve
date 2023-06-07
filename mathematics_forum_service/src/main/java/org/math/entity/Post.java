package org.math.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description: Post 实体类
 * @Author: Cauchy
 * @CreateTime: 2022/10/5
 *
 */
@Data
@Document("post")
public class Post implements Serializable {
    /**
     * 主键 id
     */
    @Id
    private Long id;
    /**
     * 内容
     */
    private String content;
    /**
     * 标题
     */
    private String title;
    /**
     * 作者
     */
    private Long authorId;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 评论
     */
    private List<Comment> comments;
    /**
     * 点赞
     */
    private int like;
    /**
     * 状态
     */
    private Boolean state;
    /**
     * 作者
     */
    private String author;
    /**
     * 热度
     */
    private int hotDegree;
    /**
     * 浏览
     */
    private int scan;
}
