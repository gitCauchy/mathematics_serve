package org.math.controller;

import org.math.response.Response;
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
    @GetMapping(value = "/getValidateCode")
    public Response getValidateCode(){
        return Response.success();
    }

    @GetMapping(value = "/checkValidateCode")
    public Response checkValidateCode(){
        return Response.success(true);
    }
}
