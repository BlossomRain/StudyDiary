package com.github.mybatis.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @Auther: lxz
 * @Date: 2020/4/9 0009
 * @Description:
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 7361210811261431677L;
    private String orderId;
    private Date createTime;
    private BigDecimal price;
    private Integer status;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", price=" + price +
                ", status=" + status +
                ", user=" + user +
                '}';
    }

    public Order() {
    }

    public Order(String orderId, Date createTime, BigDecimal price, Integer status, User user) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.price = price;
        this.status = status;
        this.user = user;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
