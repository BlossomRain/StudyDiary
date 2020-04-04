package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    //进行事务改造
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();
    private static DruidDataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            // 读取 jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从流中加载数据
            properties.load(inputStream);
            // 创建 数据库连接 池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取数据库连接池中的连接
     * 事务管理改造
     *
     * @return 如果返回null, 说明获取连接失败<br />有值就是获取连接成功
     */
    public static Connection getConnection() {

        Connection conn = conns.get();
        if (conn == null) {
            try {
                //使用同一个conn连接
                conn = dataSource.getConnection();
                conns.set(conn);//供后面使用
                conn.setAutoCommit(false);//关闭自动提交
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }


    /**
     * @Description:提交事务并关闭连接,事务改造
     * @create: 2020/4/3 0003 22:55
     * @return: void
     */
    public static void commitAndClose() {
        Connection connection = conns.get();
        if (connection != null) {//不为空,说明进行过操作
            try {
                connection.commit();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行此操作,因为tomcat底层使用了线程池技术
        conns.remove();
    }

    /**
     * @Description:回滚事务并关闭连接,事务改造
     * @create: 2020/4/3 0003 22:55
     * @return: void
     */
    public static void rollbackAndClose() {
        Connection connection = conns.get();
        if (connection != null) {//不为空,说明进行过操作
            try {
                connection.rollback();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行此操作,因为tomcat底层使用了线程池技术
        conns.remove();
    }

    /**
     * 关闭连接，放回数据库连接池
     *
     * @param conn

    public static void close(Connection conn) {
    if (conn != null) {
    try {
    conn.close();
    } catch (SQLException e) {
    e.printStackTrace();
    }
    }
    }*/

}