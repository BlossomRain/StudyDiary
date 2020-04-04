package com.atguigu.service;

import com.atguigu.pojo.Cart;

/**
 * @Auther: lxz
 * @Date: 2020/4/3 0003
 * @Description:
 */
public interface OrderService {
    String createOrder(Cart cart,Integer userId);
}
