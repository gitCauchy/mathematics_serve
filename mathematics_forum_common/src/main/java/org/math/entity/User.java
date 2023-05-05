package org.math.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>用户</p>
 *
 * @author Wuchunlei
 * @date 2023/3/14 16:29
 */
@Data
public class User implements Serializable {
    /**
     * 主键 id
     */
    private int id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 状态 0 - 正常 ， 1 - 封禁 ， 3 - 临时冻结
     */
    private int state;
    /**
     * 性别 0 - 未知 ， 1 - 男 ， 2 - 女 .
     */
    private int gender;
    /**
     * 用户类型 0 - 普通用户， 1 - 管理员用户
     */
    private int type;
}
