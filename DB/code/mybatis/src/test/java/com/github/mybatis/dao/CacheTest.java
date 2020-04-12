package com.github.mybatis.dao;

import com.github.mybatis.bean.User;
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
 * @Date: 2020/4/10 0010
 * @Description:
 */
public class CacheTest {

    private SqlSession sqlSession = null;

    /*
     * 二级缓存基于namespace的:
     * 1.优先存储与一级缓存,会话关闭才保存到二级缓存,不同的namespace有自己缓存map
     *
     */
    @Test
    public void testSecondLevelCache() throws IOException {
        SqlSession sqlSession2 = this.sqlSession;
        getSqlSession();

        UserMapper mapper1 = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);

        System.out.println(mapper1.getUserById(2));
        close();
        System.out.println(mapper2.getUserById(2));
        sqlSession=sqlSession2;
    }


    @Test//测试一级缓存
    public void testFirstLevelCache() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(3);
        System.out.println(userById);
//        查询两次,第二次不会发起sql语句,可以看出两者指向内存的同一个对象
        /*
         sqlSession级别缓存:
         1.同一级别才能生效,不同session会失效
         2.条件要相同,条件改变会失效
         3.两次相同查询之间执行了UPDATE(增删改)操作
         4.手动清除缓存
         */
        User userById2 = mapper.getUserById(3);
        System.out.println(userById == userById2);
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
