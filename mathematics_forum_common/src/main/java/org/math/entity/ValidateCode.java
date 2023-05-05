package org.math.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>验证码</p>
 *
 * @author Wuchunlei
 * @date 2023/5/5 9:49
 */
@Data
@AllArgsConstructor
public class ValidateCode implements Serializable {
    /**
     * 键
     */
    private String key;
    /**
     * 验证码
     */
    private String code;
}
