package com.reflectionTest;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: lxz
 * @Date: 2020/3/22 0022
 * @Description: 测试反射机制
 */
public class ReflectionTest {
    //测试反射的常见用法

    @Test   //获取对象
    public void testCons() throws Exception {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();

        Constructor<Person> cons = clazz.getDeclaredConstructor();
        Person per = cons.newInstance();

    }


    @Test   //简单演示
    public void testReflection() throws Exception, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<Person> clazz = Person.class;
        Constructor<Person> cons = clazz.getConstructor(String.class, int.class);
        //创建对象
        Person tom = cons.newInstance("Tom", 1);
        System.out.println(tom.getName() + "---" + tom.getAge());
        //修改属性
        Field age = clazz.getDeclaredField("age");
        age.set(tom, 2);

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        cons.setAccessible(true);
        show.invoke(tom);
    }

}
