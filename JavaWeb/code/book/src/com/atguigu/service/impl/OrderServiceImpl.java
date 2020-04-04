package com.atguigu.service.impl;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;

import java.sql.Date;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: lxz
 * @Date: 2020/4/3 0003
 * @Description:
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao itemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        //必须唯一性
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(System.currentTimeMillis()), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);
        //遍历商品项并保存
        Set<Map.Entry<Integer, CartItem>> entries = cart.getItems().entrySet();
        for (Map.Entry<Integer, CartItem> entry : entries) {
            CartItem item = entry.getValue();
            OrderItem orderItem = new OrderItem(null, item.getName(), item.getCount(), item.getPrice(), item.getTotalPrice(), orderId);
            itemDao.saveOrderItem(orderItem);
            //修改库存和销量
            Book book = bookDao.queryBookById(item.getId());
            book.setSales(book.getSales() + item.getCount());
            book.setStock(book.getStock() - item.getCount());
            bookDao.updateBook(book);
        }
        //清空购物车
        cart.clear();
        return orderId;
    }
}
