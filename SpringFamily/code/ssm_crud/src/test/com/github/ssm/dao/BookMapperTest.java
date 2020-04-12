package com.github.ssm.dao;

import com.github.ssm.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

/**
 * @Auther: lxz
 * @Date: 2020/4/11 0011
 * @Description:测试dao层,不使用Junit,而是用spring的测试模块
 */
/*
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicatonContext.xml"})
public class BookMapperTest {

    @Autowired
    BookMapper mapper;
    @Test
    public void testCRUD(){
        System.out.println(mapper);
        Book book = new Book(null,"《重构:改善既有代码的设计》","（美）福勒 ",
                new BigDecimal(69.00),42,2342,"static/img/default.jpg");
        mapper.insertSelective(book);

    }
    

}*/
