package com.atguigu.test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Date;


/**
 * @Auther: lxz
 * @Date: 2020/4/3 0003
 * @Description:
 */
public class OrderDaoTest {
    OrderDao dao = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        Order order = new Order("123", new Date(3123113321231L), new BigDecimal(2), 0, 1);
        dao.saveOrder(order);
    }


}