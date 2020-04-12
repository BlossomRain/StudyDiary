package com.github.mybatis.dao;

import com.github.mybatis.bean.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: lxz
 * @Date: 2020/4/9 0009
 * @Description:
 */
public class OrderMapperTest {

    private SqlSession sqlSession = null;

    @Test
    public void testResultMap(){
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Order orderById = mapper.getOrderById("123");
        System.out.println(orderById);
    }


    //自动获取sqlSession,注意不是线程安全的,每次都要获取新的一个对象
    @Before
    public void getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession();
    }

    //自动提交并关闭sqlSession
    @After
    public void close() {
        sqlSession.commit();
        sqlSession.close();
    }

}