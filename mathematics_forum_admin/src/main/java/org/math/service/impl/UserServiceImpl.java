package org.math.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.math.entity.User;
import org.math.mapper.UserMapper;
import org.math.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author Wuchunlei
 * @date 2023/3/14 16:10
 */
@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUserList(User user) {
        User user1 = new User();
        user1.setUsername("蒋玲玲");
        user1.setGender(2);
        user1.setState(0);

        User user2 = new User();
        user1.setUsername("测试用户");
        user1.setGender(2);
        user1.setState(1);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        return userList;
    }
}
