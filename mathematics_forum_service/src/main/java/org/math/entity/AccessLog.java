package org.math.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AccessLog implements Serializable {
    /**
     * 用户名
     */
    private String username;
    /**
     * url
     */
    private String url;
    /**
     * 请求消耗时长
     */
    private Integer duration;
    /**
     * 请求方法
     */
    private String httpMethod;
    /**
     * 请求响应状态码
     */
    private Integer httpStatus;
    /**
     * ip 地址
     */
    private String ip;
    /**
     * 记录创建日期
     */
    private LocalDateTime createTime;
}
