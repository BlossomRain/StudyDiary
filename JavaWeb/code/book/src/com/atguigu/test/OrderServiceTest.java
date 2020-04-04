package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Auther: lxz
 * @Date: 2020/4/3 0003
 * @Description:
 */
public class OrderServiceTest {

    OrderService service = new OrderServiceImpl();
    Cart cart = new Cart();
    @Test
    public void createOrder() {
        cart.addItem(new CartItem(1, "a", 2, new BigDecimal(2)));
        cart.addItem(new CartItem(1, "a", 2, new BigDecimal(2)));
        cart.addItem(new CartItem(2, "b", 3, new BigDecimal(2)));

        System.out.println(service.createOrder(cart, 1));
    }


}