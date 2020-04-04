package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Auther: lxz
 * @Date: 2020/4/2 0002
 * @Description:购物车
 */
public class Cart {
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }


    public Cart() {
    }

    /**
     * 添加商品
     */
    public void addItem(CartItem item) {
        //先查看商品是否添加
        CartItem cartItem = items.get(item.getId());
        if (cartItem == null) {
            cartItem = item;
            items.put(item.getId(), item);
        } else {
            cartItem.setCount(item.getCount() + cartItem.getCount());
        }
        cartItem.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));

    }

    /**
     * 删除商品
     */
    public void removeItem(Integer id) {
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear() {
        items.clear();
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    /**
     * 修改数量
     */
    public void updateCount(Integer id, Integer count) {

        CartItem cartItem = items.get(id);
        if (cartItem != null) {
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }

    public Integer getTotalCount() {
        int totalCount = 0;
        for (CartItem value : items.values()) {
            totalCount += value.getCount();
        }

        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);

        for (CartItem item : items.values()) {
            totalPrice = totalPrice.add(item.getTotalPrice());
        }

        return totalPrice;
    }


}
