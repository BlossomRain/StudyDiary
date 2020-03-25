package com.reflectionTest;

import java.io.Serializable;

/**
 * @Auther: lxz
 * @Date: 2020/3/23 0023
 * @Description:用于person类的父类,测试反射获取
 */
public class Creature<T> implements Serializable {

    private char gender;
    public double weight;

    private void breath() {
        System.out.println("breathing.....");
    }

    public void eat(){
        System.out.println("eating...");
    }

}
