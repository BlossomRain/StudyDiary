package com.basicTest;

import java.util.Random;

/**
 * @Auther: lxz
 * @Date: 2020/3/14 0014
 * @Description:测试多态的运行时行为
 */
public class polymorphism {
    class A {
        public void say() {
            System.out.println("A");
        }
    }

    class B extends A {
        @Override
        public void say() {
            System.out.println("B");
        }
    }

    public static void main(String[] args) {
        int i = new Random().nextInt(3);
        for (int j = 0; j < 3; j++) {
            A instance = new polymorphism().getInstance(i);
            instance.say();
        }
    }

    //获取随机的对象实例
    public A getInstance(int i) {
        A instance = null;
        if (i < 2) {
            instance=new A();
        }else {
            instance=new B();
        }

        return instance;
    }

}
