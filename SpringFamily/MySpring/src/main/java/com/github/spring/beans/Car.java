package com.github.spring.beans;

/**
 * @Auther: lxz
 * @Date: 2020/4/4 0004
 * @Description:
 */
public class Car {
    private String name;
    private String color;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
