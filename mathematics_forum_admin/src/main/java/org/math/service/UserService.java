package org.math.service;

import org.math.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author Wuchunlei
 * @date 2023/3/14 16:09
 */
@Service
public interface UserService {
    List<User> getUserList(User user);
}
