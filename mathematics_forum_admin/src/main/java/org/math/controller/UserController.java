package org.math.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.math.entity.User;
import org.math.response.Response;
import org.math.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getUserList")
    public Response getUserList() {
        List<User> userList = userService.getUserList(null);
        return Response.success(userList);
    }
}
