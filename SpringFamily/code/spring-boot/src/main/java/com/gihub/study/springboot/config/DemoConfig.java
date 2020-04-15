package com.gihub.study.springboot.config;

import com.gihub.study.springboot.pojo.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: lxz
 * @Date: 2020/4/12 0012
 * @Description:
 */
//@Configuration
public class DemoConfig {

    @Bean
    public Pet pet() {
        return new Pet("langx", "red");
    }
}
