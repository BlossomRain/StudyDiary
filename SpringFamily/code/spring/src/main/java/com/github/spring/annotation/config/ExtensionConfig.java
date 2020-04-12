package com.github.spring.annotation.config;

import com.github.spring.beans.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: lxz
 * @Date: 2020/4/8 0008
 * @Description:测试拓展原理
 */

@ComponentScan("com.github.spring.annotation.extension")
@Configuration
public class ExtensionConfig {
    @Bean
    public Car car() {
        return new Car();
    }
}
