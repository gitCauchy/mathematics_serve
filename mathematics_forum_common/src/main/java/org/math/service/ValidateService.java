package org.math.service;

import org.math.entity.ValidateImage;
import org.springframework.stereotype.Service;

@Service
public interface ValidateService {
    /**
     * 获取图片验证码
     *
     * @return ValidateCode Object
     */
    ValidateImage getValidateCode(int userId);

    boolean check(int userId, String code);
}
