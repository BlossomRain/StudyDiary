package com.test.dao;

import com.test.util.JDBCUtil;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lxz
 * @Date: 2020/3/27 0027
 * @Description:封装了对表的通用操作
 */
public abstract class BaseDAO<T> {

    private Class<T> clazz = null;
    {
        Type superclass = this.getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) superclass;
        clazz = (Class<T>) paramType.getActualTypeArguments()[0];
    }

    //返回一个数值的聚合函数
    public <T> T getValue(Connection connection, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            resultSet = ps.executeQuery();


            if (resultSet.next()) {

                return (T) resultSet.getObject(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(null, ps, resultSet);
        }


        return null;
    }

    //通用增删改
    public int update(Connection connection, String sql, Object... args) {

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 1; i <= args.length; i++) {
                ps.setObject(i, args[i - 1]);
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(null, ps);
        }
        return 0;

    }

    //通用的查询操作---多个表
    public   T queryOne(Connection connection, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            resultSet = ps.executeQuery();

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
            JDBCUtil.release(null, ps, resultSet);
        }

        return null;

    }

    public  List<T> queryList(Connection connection, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            resultSet = ps.executeQuery();

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
            JDBCUtil.release(null, ps, resultSet);
        }

        return null;

    }
}
