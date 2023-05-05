package org.math.controller;

import org.apache.ibatis.annotations.Param;
import org.math.entity.ValidateImage;
import org.math.response.Response;
import org.math.service.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>验证码 Controller</p>
 *
 * @author Wuchunlei
 * @date 2023/5/5 9:23
 */
@RestController
@RequestMapping("/api/validate")
public class ValidateController {
    @Autowired
    ValidateService validateService;

    @GetMapping(value = "/getValidateCode")
    public Response getValidateCode(@Param(value = "userId") int userId) {
        ValidateImage validateImage = validateService.getValidateCode(userId);
        return Response.success(validateImage);
    }

    @GetMapping(value = "/checkValidateCode")
    public Response checkValidateCode(@Param(value = "userId") int userId, @Param(value = "code") String code) {
        boolean result = validateService.check(userId, code);
        return Response.success(result);
    }
}
