package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Auther: lxz
 * @Date: 2020/4/2 0002
 * @Description:
 */
public class CartTest {

    Cart cart = new Cart();

    @Test
    public void addItem() {


        cart.addItem(new CartItem(1, "a", 2, new BigDecimal(2)));
        cart.addItem(new CartItem(1, "a", 2, new BigDecimal(2)));
        cart.addItem(new CartItem(1, "a", 2, new BigDecimal(2)));
        cart.addItem(new CartItem(2, "b", 1, new BigDecimal(12)));

        System.out.println(cart);
    }

    @Test
    public void removeItem() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void updateCount() {
        addItem();
        cart.updateCount(1,9);
        System.out.println(cart);
    }
}