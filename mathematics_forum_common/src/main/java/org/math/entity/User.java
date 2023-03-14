package org.math.entity;

import lombok.Data;

/**
 * <p>TODO</p>
 *
 * @author Wuchunlei
 * @date 2023/3/14 16:29
 */
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private int state;
    private int gender;
}
