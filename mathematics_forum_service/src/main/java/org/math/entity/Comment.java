package org.math.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Comment implements Serializable {
    /**
     * 主键 ID
     */
    private long id;
    /**
     * 内容
     */
    private String content;
    /**
     * 发布者 ID
     */
    private long userId;
    /**
     * post ID
     */
    private long postId;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 状态
     */
    private int status;
    /**
     * 作者
     */
    private String author;
    /**
     * 点赞
     */
    private int like;
}
