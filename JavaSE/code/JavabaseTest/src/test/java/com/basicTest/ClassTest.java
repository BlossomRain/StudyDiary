package com.basicTest;

import org.junit.Test;

import java.lang.reflect.Type;

/**
 * @Auther: lxz
 * @Date: 2020/3/13 0013
 * @Description:对类结构进行测试
 */
public class ClassTest {


    //构造器 this的测试
    ClassTest(){

    }

    ClassTest(int a){
        this();
    }


    String test(String... args) {
//        System.out.println("test method");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        return args.getClass().toString();
    }

    @Test   //测试可变形参
    public void testVarargs() {
        String test = test("1", "2", "3");
        System.out.println(test);
        System.out.println(new String[1].getClass());
    }



}
