package com.test;

import org.junit.Test;

/**
 * @Auther: lxz
 * @Date: 2020/3/25 0025
 * @Description:类和对象的测试
 */
public class ClassTest {


    //证明Java的引用传递是传递的是引用的副本
    @Test
    public void testReference() {
        Apple red = new Apple("red", 1.1);
        Apple green = new Apple("green", 1.2);

        appleSwitch(red, green);
        //假如交换成功,结果应该是先绿苹果,再红苹果
        System.out.println(red);
        System.out.println(green);
    }

    private void appleSwitch(Apple red, Apple green) {
        Apple temp = red;
        red = green;
        green = temp;
    }

}
