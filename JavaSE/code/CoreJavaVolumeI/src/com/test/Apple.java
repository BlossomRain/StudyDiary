package com.test;

import java.util.Objects;

/**
 * @Auther: lxz
 * @Date: 2020/3/25 0025
 * @Description:一个简单的类,用于测试用例
 */
public class Apple {


    private String color;
    private double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return Double.compare(apple.price, price) == 0 &&
                Objects.equals(color, apple.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, price);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Apple() {
    }

    public Apple(String color, double price) {
        this.color = color;
        this.price = price;
    }
}
