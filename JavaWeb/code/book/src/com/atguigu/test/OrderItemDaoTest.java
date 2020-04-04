package com.atguigu.test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Auther: lxz
 * @Date: 2020/4/3 0003
 * @Description:
 */
public class OrderItemDaoTest {

    OrderItemDao dao = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {
        OrderItem orderItem = new OrderItem(null, "Java", 1, new BigDecimal(1), new BigDecimal(1), "123");
        dao.saveOrderItem(orderItem);
    }

}