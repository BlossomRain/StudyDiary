package com.test.dao;

import com.test.bean.Customer;
import com.test.util.JDBCUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: lxz
 * @Date: 2020/3/27 0027
 * @Description:
 */
public class CustomerDAOImplTest {
    CustomerDAOImpl dao;
    Connection conn;

    @Before
    public void testBefore() {
        dao = new CustomerDAOImpl();
        try {
            conn = JDBCUtil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void testAfter() {
        JDBCUtil.release(conn, null);
    }


    @Test
    public void insert() {
        Customer customer = new Customer(1,"小红花","上海","999",new Date(41242341234L));
        dao.insert(conn,customer);

    }

    @Test
    public void deleteById() {
        dao.deleteById(conn,1);
    }

    @Test
    public void update() {
        Customer customer = new Customer(4,"小花","上海","999",new Date(41242341234L));
        dao.update(conn,customer);
    }

    @Test
    public void getCustomerById() {
        Customer customerById = dao.getCustomerById(conn, 6);
        System.out.println(customerById);
    }

    @Test
    public void getCustomers() {
        List<Customer> customers = dao.getCustomers(conn);
        customers.forEach(System.out::println);
    }

    @Test
    public void getCount() {
        Long count = dao.getCount(conn);
        System.out.println(count);
    }

    @Test
    public void getMaxBirth() {
        System.out.println(dao.getMaxBirth(conn));
    }
}