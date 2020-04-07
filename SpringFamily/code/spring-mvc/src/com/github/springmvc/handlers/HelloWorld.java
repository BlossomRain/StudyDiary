package com.github.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: lxz
 * @Date: 2020/4/6 0006
 * @Description:第一次使用springmvc
 */

@Controller
public class HelloWorld {

    /**
    * @Description: 使用这个标签来映射请求,跟当初用servlet一样
    * @create: 2020/4/6 0006 12:44
    * @return: java.lang.String
    */ 
    @RequestMapping("/helloWorld")
    public String hello() {
        System.out.println("hello world");
        return "success";
    }
}
