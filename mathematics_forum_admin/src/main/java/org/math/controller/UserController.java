package org.math.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.math.entity.User;
import org.math.response.Response;
import org.math.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author Wuchunlei
 * @date 2023/3/14 16:05
 */
@RestController
@RequestMapping("/api/user")
@NoArgsConstructor
@AllArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/getUserList")
    public Response getUserList(@RequestBody User user) {
        List<User> userList = userService.getUserList(user);
        return Response.success(userList);
    }
}
