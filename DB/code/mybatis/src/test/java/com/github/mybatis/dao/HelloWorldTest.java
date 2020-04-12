package com.github.mybatis.dao;


import com.github.mybatis.bean.User;
import com.github.mybatis.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @Auther: lxz
 * @Date: 2020/4/8 0008
 * @Description:测试Mybatis的使用
 */
public class HelloWorldTest {
    private SqlSession sqlSession = null;


    //测试返回为集合 Map类型
    @Test
    public void testResultType(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> users = mapper.getUsers();
//        for (User user : users) {
//            System.out.println(user);
//        }
        Map<Integer, User> users = mapper.getUsersMap();
        System.out.println(users);
    }


    @Test//使用接口映射
    public void testInterfaceMapping() throws IOException {

        //获取接口对应的实现类对象(代理对象)
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        System.out.println(mapper.getUserById(2));

        User xiaoAA = new User(null, "xiaoCC", "123", "faksd@fskdfs.com");
        mapper.insertUser(xiaoAA);
        System.out.println(xiaoAA);
//        User xiaoBB = new User(16, "xiaoBB", "123", "faksd@fskdfs.com");
//        mapper.updateUser(xiaoBB);
    }


    @Test//使用最原始的映射文件的方式
    public void testHelloWorld() throws IOException {
        User user = sqlSession.selectOne("selectUser", 2);
        System.out.println(user);
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