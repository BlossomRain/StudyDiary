package com.test.dao;

import com.test.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @Auther: lxz
 * @Date: 2020/3/27 0027
 * @Description:定义关于Customer表的操作
 */
public interface CustomerDAO {

    /**
     * @param connection:
     * @param customer:
     * @Description: 将传入的对象插入到表中
     * @create: 2020/3/27 0027 12:38
     * @return: void
     */
    void insert(Connection connection, Customer customer);

    /**
     * @param connection:
     * @param id:
     * @Description: 根据指定的id删除表中的记录
     * @create: 2020/3/27 0027 12:39
     * @return: void
     */
    void deleteById(Connection connection, int id);

    void update(Connection connection, Customer customer);

    Customer getCustomerById(Connection connection, int id);

    List<Customer> getCustomers(Connection connection);

    Long getCount(Connection connection);

    Date getMaxBirth(Connection connection);
}
