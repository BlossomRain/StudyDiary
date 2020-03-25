package com.test;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @Auther: lxz
 * @Date: 2020/3/25 0025
 * @Description:测试基本数据类型的一些注意事项
 */
public class PrimitiveTest {
    //String测试
    @Test
    public void testString() {
        final int age = 1;
        String s1 = "png" + null;
        System.out.println("pngnull" == s1);
        System.out.println(s1);

        //代码单元  码点
        int i = s1.codePointCount(0, s1.length());
        System.out.println(i);

        IntStream intStream = s1.codePoints();
        intStream.map(s -> (char)s).forEach(System.out::println);
    }


    //char类型
    @Test
    public void testChar() {
        System.out.println("\u2122\u03C0");
        // \u00A0  C:\USER 可能会发生错误

    }


    /**
     * @Description: 测试数字类型的注意事项
     * @create: 2020/3/25 0025 10:57
     * @return: void
     */
    @Test//数字类型
    public void testNumber() {

        //数字 下划线
        long num = 1_000_000L;
//        System.out.println(num/0);// / by zero
//        System.out.println(-1.0 / 0);//Infinity -Infinity
        System.out.println(0.0 / 0);
    }

    
}
