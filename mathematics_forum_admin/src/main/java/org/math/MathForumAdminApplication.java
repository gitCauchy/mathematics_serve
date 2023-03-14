package org.math;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>TODO</p>
 *
 * @author Wuchunlei
 * @date 2023/3/13 14:04
 */
@SpringBootApplication
@MapperScan(basePackages = {"org.math.mapper"})
public class MathForumAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(MathForumAdminApplication.class, args);
    }
}
