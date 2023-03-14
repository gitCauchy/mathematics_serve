package org.math.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.math.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author Wuchunlei
 * @date 2023/3/14 15:55
 */
@Mapper
@Repository
public interface UserMapper {
    List<User> getUserList(User user);
}
