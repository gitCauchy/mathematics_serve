package org.math.service.impl;

import org.math.entity.ValidateImage;
import org.math.service.ValidateService;
import org.math.utils.RedisUtil;
import org.math.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>验证码 Service</p>
 *
 * @author Wuchunlei
 * @date 2023/5/5 9:45
 */
public class ValidateServiceImpl implements ValidateService {
    @Autowired
    RedisUtil redisUtil;

    @Override
    public ValidateImage getValidateCode(int userId) {
        ValidateImage validateImage = ValidateUtil.getValidateImage();
        redisUtil.set("ValidateCode:" + userId, validateImage.getValue());
        return validateImage;
    }

    @Override
    public boolean check(int userId, String code) {
        String s = redisUtil.get("ValidateCode:" + userId);
        return s.equals(code);
    }
}
