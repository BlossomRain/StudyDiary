package com.test;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Auther: lxz
 * @Date: 2020/3/25 0025
 * @Description:测试jdbc
 */
public class Basic {

    //最终版
    @Test
    public void testJDBC5() throws Exception{

        //获取配置文件
        InputStream is = Basic.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(is);
        //获取属性
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");
        //注册,获取连接
        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);


    }



    //jdbc的连接获取4
    @Test
    public void testJDBC4() throws Exception {
        //选择驱动--反射实现--使用DriverManager

        //用户名,密码等相关信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";
        //自动帮我们注册
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, user,password);
        //选择连接的数据库


        System.out.println(connection);

    }


    //jdbc的连接获取3
    @Test
    public void testJDBC3() throws Exception {
        //选择驱动--反射实现--使用DriverManager

        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        //用户名,密码等相关信息
        String url = "jdbc:mysql://localhost:3306/test";
        //
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, info);
        //选择连接的数据库


        System.out.println(connection);

    }

    //jdbc的连接获取2
    @Test
    public void testJDBC2() throws Exception {
        //选择驱动--反射实现

        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();


        //选择连接的数据库
        String url = "jdbc:mysql://localhost:3306/test";
        //用户名,密码等相关信息
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        Connection connect = driver.connect(url, info);
        System.out.println(connect);

    }

    //jdbc的连接获取1
    @Test
    public void testJDBC1() throws SQLException {
        //选择驱动
        Driver driver = new com.mysql.jdbc.Driver();
        //选择连接的数据库
        String url = "jdbc:mysql://localhost:3306/test";
        //用户名,密码等相关信息
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        Connection connect = driver.connect(url, info);
        System.out.println(connect);

    }

}
