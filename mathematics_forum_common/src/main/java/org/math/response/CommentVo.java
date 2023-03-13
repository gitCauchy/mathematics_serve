package org.math.response;

import lombok.Data;

/**
 * @Description: Comment value object
 * @Author: Cauchy
 * @CreateTime: 2022/10/24
 */
@Data
public class CommentVo {
    /**
     * 作者
     */
    private String author;
    /**
     * 点赞数
     */
    private int like;
    /**
     * 内容
     */
    private String content;
}
