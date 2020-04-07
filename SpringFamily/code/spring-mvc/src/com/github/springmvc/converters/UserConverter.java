package com.github.springmvc.converters;

import com.github.springmvc.beans.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;

/**
 * @Auther: lxz
 * @Date: 2020/4/7 0007
 * @Description:自定义转换器,通常是不需要的,输入一个字符串,转换成对应的对象
 */
@Controller
public class UserConverter implements Converter<String, User> {
    @Override
    public User convert(String s) {
        if (s != null && s.length() != 0) {
            String[] split = s.split("-");
            if (split.length == 4) {
                //根据参数创建对象并返回
            }
        }

        return null;
    }
}
