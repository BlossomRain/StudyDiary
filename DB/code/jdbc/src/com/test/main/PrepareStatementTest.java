package com.test.main;

import com.test.bean.Customer;
import com.test.util.JDBCUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Auther: lxz
 * @Date: 2020/3/25 0025
 * @Description:测试sql语句
 */
public class PrepareStatementTest {


    //测试批量数据操作
    @Test
    public void testBatch() throws Exception {
        Connection connection = JDBCUtil.getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT into customers(name)values (?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        for (int i = 0; i < 20_000; i++) {

            ps.setString(1, "Name_" + i);
            ps.addBatch();

            if (i % 500 == 0) {
                ps.executeBatch();
                ps.clearBatch();
            }
        }

        connection.commit();
        connection.setAutoCommit(true);
        JDBCUtil.release(connection, ps);
    }


    //测试blob类型数据
    @Test
    public void testBlob() throws Exception {
        Connection connection = JDBCUtil.getConnection();

        String sql = "UPDATE customers set photo = ? where  id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        InputStream is = new FileInputStream(new File("src/images/5a4cca2b4f2dd.jpg"));
        ps.setBlob(1, is);
        ps.setObject(2, 3);

        ps.executeUpdate();

        is.close();
        JDBCUtil.release(connection, ps);

    }


    @Test
    public void testQueryList() {
        String sql = "select id,name,address,phone,birth from customers where id > ?";
        List<Customer> customers = queryList(Customer.class, sql, 2);
        customers.forEach(System.out::println);
    }


    //通用的查询操作---多个表
    public <T> List<T> queryList(Class<T> clazz, String sql, Object... args) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtil.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            ResultSet resultSet = ps.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();//获取结果集的元数据

            List<T> list = new ArrayList<>(metaData.getColumnCount());


            while (resultSet.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    Object value = resultSet.getObject(i + 1);
                    //获取列名--->获取列的别名
//                    String columnName = metaData.getColumnName(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);

                    //给对象的属性赋值
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, value);

                }
                list.add(t);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(connection, ps);
        }

        return null;

    }


    @Test
    public void testQueryOne() {
        String sql = "select name,address,phone,birth from customers where id = ?";
        Customer customer = queryOne(Customer.class, sql, 3);
        System.out.println(customer);
    }

    //通用的查询操作---多个表
    public <T> T queryOne(Class<T> clazz, String sql, Object... args) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtil.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            ResultSet resultSet = ps.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();//获取结果集的元数据

            T t = clazz.newInstance();

            if (resultSet.next()) {
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    Object value = resultSet.getObject(i + 1);
                    //获取列名--->获取列的别名
//                    String columnName = metaData.getColumnName(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);

                    //给对象的属性赋值
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, value);

                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(connection, ps);
        }

        return null;

    }

    @Test
    public void testQueryForCustomers() {
        String sql = "select name,address,phone,birth from customers where id = ?";
        Customer customer = queryForCustomers(sql, 3);
        System.out.println(customer);
    }

    //通用的查询操作----针对一个表
    public Customer queryForCustomers(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtil.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            ResultSet resultSet = ps.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();//获取结果集的元数据
            Customer customer = new Customer();
            if (resultSet.next()) {
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    Object value = resultSet.getObject(i + 1);
                    //获取列名--->获取列的别名
//                    String columnName = metaData.getColumnName(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);

                    //给对象的属性赋值
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(customer, value);

                }
                return customer;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(connection, ps);
        }

        return null;
    }


    //查询操作
    @Test
    public void testQuery() throws Exception {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select id,name,address,phone,birth from customers where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, 3);

        ResultSet resultSet = ps.executeQuery();
        //处理结果集
        if (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String phone = resultSet.getString(4);
            Date birth = resultSet.getDate(5);

            //封装到对象里面

            Customer customer = new Customer(id, name, address, phone, birth);
            System.out.println(customer);
        }

        JDBCUtil.release(connection, ps);

    }


    //通用增删改
    public void update(String sql, Object... args) throws Exception {

        Connection connection = JDBCUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        for (int i = 1; i <= args.length; i++) {
            ps.setObject(i, args[i - 1]);
        }
        ps.executeUpdate();

        JDBCUtil.release(connection, ps);

    }


    public Connection getConnn() throws Exception {
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

    public void release(Connection connection, PreparedStatement ps) {
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
    }

    //增删改  查
    @Test
    public void testAdd() throws Exception {
        Connection connn = getConnn();
        //3	xiaoA	Shanghai	10010
        String sql = "INSERT INTO customers(name,address,phone) VALUES (?,?,?)";
        PreparedStatement statement = connn.prepareStatement(sql);
        statement.setString(1, "小明");
        statement.setString(2, "Beijing");
        statement.setString(3, "999");

        int i = statement.executeUpdate();
        release(connn, statement);

    }


    //修改
    @Test
    public void testModify() throws Exception {

        Connection conn = JDBCUtil.getConnection();

        String sql = "UPDATE customers set name = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1, "Mozart");
        ps.setObject(2, 2);

        ps.executeUpdate();

        JDBCUtil.release(conn, ps);

    }


}
