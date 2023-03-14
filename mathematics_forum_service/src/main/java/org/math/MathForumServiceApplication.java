package org.math;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>TODO</p>
 *
 * @author Wuchunlei
 * @date 2023/3/13 14:06
 */
@SpringBootApplication
@MapperScan(basePackages = {"org.math.mapper"})
public class MathForumServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MathForumServiceApplication.class,args);
    }
}
