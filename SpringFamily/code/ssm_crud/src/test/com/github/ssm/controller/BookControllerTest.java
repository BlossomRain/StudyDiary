package com.github.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.github.ssm.bean.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: lxz
 * @Date: 2020/4/11 0011
 * @Description:使用spring的测试模块测试请求功能
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicatonContext.xml",
        "file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class BookControllerTest {

    //获取springmvc的ioc容器
    @Autowired
    WebApplicationContext context;
    //    虚拟mvc
    MockMvc mockMvc;

    @Before
    public void initMokcMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getBooks() throws Exception {
        //模拟请求拿到返回值
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/books").param("pn", "1"))
                .andReturn();
        //取出page进行验证
        MockHttpServletRequest request = result.getRequest();
        PageInfo page = (PageInfo) request.getAttribute("page");
        System.out.println("当前页码" + page.getPageNum());
        List<Book> list = page.getList();
        for (Book book : list) {
            System.out.println(book);
        }


    }
}
