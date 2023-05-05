package org.math.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>验证码</p>
 *
 * @author Wuchunlei
 * @date 2023/5/5 14:11
 */
@Data
public class ValidateImage implements Serializable {
    /**
     * Base64 验证码
     */
    private String base64Str;
    /**
     * 验证码值
     */
    private String value;
}
