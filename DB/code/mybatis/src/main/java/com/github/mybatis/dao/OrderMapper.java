package com.github.mybatis.dao;

import com.github.mybatis.bean.Order;

/**
 * @Auther: lxz
 * @Date: 2020/4/9 0009
 * @Description:
 */
public interface OrderMapper {
    Order getOrderById(String id);
}
