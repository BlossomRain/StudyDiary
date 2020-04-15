package com.gihub.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//可以引入别的位置的配置文件
@ImportResource(locations = {})
//配置文件类 spring扫描该类所在的包及子包,要注意不要把配置文件放到其他位置
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
