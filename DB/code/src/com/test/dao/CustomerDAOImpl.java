package com.test.dao;

import com.test.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @Auther: lxz
 * @Date: 2020/3/27 0027
 * @Description:
 */
public class CustomerDAOImpl extends BaseDAO<Customer> implements CustomerDAO {
    @Override
    public void insert(Connection connection, Customer customer) {
        String sql = "insert into customers(name,address,phone,birth)values(?,?,?,?)";
        update(connection, sql, customer.getName(), customer.getAddress(), customer.getPhone(), customer.getBirth());

    }

    @Override
    public void deleteById(Connection connection, int id) {
        String sql = "delete from customers where id = ?";
        update(connection, sql, id);
    }

    @Override
    public void update(Connection connection, Customer customer) {
        String sql = "update  customers set name=?,address=?,phone=?,birth=? where id =?";
        update(connection, sql, customer.getName(), customer.getAddress(), customer.getPhone(), customer.getBirth(), customer.getId());
    }

    @Override
    public Customer getCustomerById(Connection connection, int id) {
        String sql = "select id,name,address,phone,birth from customers where id = ?";
        Customer customer = queryOne(connection, sql, id);
        return customer;
    }

    @Override
    public List<Customer> getCustomers(Connection connection) {
        String sql = "select id,name,address,phone,birth from customers";
        List<Customer> customers = queryList(connection, sql);
        return customers;
    }

    @Override
    public Long getCount(Connection connection) {
        String sql = "select count(*) from customers";
        Object value = getValue(connection, sql);
        return (Long) value;
    }

    @Override
    public Date getMaxBirth(Connection connection) {
        String sql = "select Max(birth) from customers";
        Object value = getValue(connection, sql);
        return (Date) value;
    }
}
