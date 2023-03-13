package org.math.response;

import lombok.Data;

import java.util.List;

/**
 * @Description: Post value object
 * @Author: Cauchy
 * @CreateTime: 2022/10/24
 */
@Data
public class PostVo {
    /**
     * id
     */
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 作者
     */
    private String author;
    /**
     * 评论
     */
    private List<CommentVo> comments;
    /**
     * 点赞数量
     */
    private int like;
}
