package com.gihub.study.springboot.pojo;

/**
 * @Auther: lxz
 * @Date: 2020/4/12 0012
 * @Description:
 */
public class Pet {
    private String name;
    private String color;

    public Pet() {
    }

    public Pet(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Pet{" +
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
