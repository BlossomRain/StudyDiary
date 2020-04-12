package com.test.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Auther: lxz
 * @Date: 2020/3/26 0026
 * @Description:封装一些关于JDBC的常用操作
 */
public class JDBCUtil {

    private static ComboPooledDataSource myC3P0 = new ComboPooledDataSource("myC3P0");

    private static Properties pros = null;
    private static DataSource dataSource = null;
    static {
        pros = new Properties();
        InputStream is = ClassLoader.getSystemResourceAsStream("druid.properties");
        try {
            pros.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (is != null)
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() throws Exception {
//        return getConnectionFromC3P0();
        return getConnectionFromDruid();
    }


    public static Connection getConnectionFromC3P0() throws SQLException {

        Connection connection = myC3P0.getConnection();
        return connection;
    }

    public static Connection getConnectionFromDruid() throws Exception {


        return dataSource.getConnection();
    }

    /**
     * @Description:获取一个连接
     * @create: 2020/3/26 0026 19:57
     * @return: java.sql.Connection
     */

    /**
     public static Connection getConnection() throws Exception {
     InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
     Properties info = new Properties();
     info.load(is);

     String user = info.getProperty("user");
     String password = info.getProperty("password");
     String url = info.getProperty("url");
     String driverClass = info.getProperty("driverClass");

     Class.forName(driverClass);
     Connection connection = DriverManager.getConnection(url, user, password);

     return connection;
     }
     */

    /**
     * @Description: 释放资源, 已经处理为空的情况
     * @create: 2020/3/26 0026 19:59
     * @return: void
     */
    public static void release(Connection connection, PreparedStatement ps) {
        release(connection, ps, null);
    }

    public static void release(Connection connection, PreparedStatement ps, ResultSet rs) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
