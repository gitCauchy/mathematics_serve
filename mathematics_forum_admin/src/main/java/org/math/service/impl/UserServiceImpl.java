package org.math.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.math.entity.User;
import org.math.mapper.UserMapper;
import org.math.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userMapper.getUserList(user);
    }
}
