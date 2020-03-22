package com.basicTest;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: lxz
 * @Date: 2020/3/8 0008
 * @Description:测试基本类型的用法
 */
public class BasicUsageTest {


    @Test   //测试基本类型用法注意事项
    public void testBasicUse() {
        //错误: 非法的 Unicode 转义

//        System.out.println(1.0/0);//Infinity
//        1 / 0  :java.lang.ArithmeticException: / by zero

        String s = "java\uD835\uDD46";
//        System.out.println(s.substring(1,2));
//        System.out.println(String.join("/","1","2"));
//        System.out.println("a".equals("A"));
        //码点  和 代码单元,使用码点更好
        /*System.out.println("代码单元数量" + s.length());
        System.out.println("码点数量"+s.codePointCount(0,s.length()));
        System.out.println(s.codePointAt(1));*/
//        StringBuffer buffer = new StringBuffer();
//        StringBuilder builder = new StringBuilder();
//        System.out.println(System.getProperty("user.dir"));//项目路径

        read_data:
        //测试break的标记
//        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i > 5) break read_data;
        }
    }

    @Test
    public void testOperation() {
        int i = 10;
        i = i++;
        System.out.println(i);
        System.out.println("=====");
        byte num = 10;
        num += 10;
        num++;
        System.out.println(getType(num));
    }
    public String getType(Object object){
        return object.getClass().toString();
    }

    @Test   //测试string用法1
    public void testString() {
        //编译不通过
        // char c = '';
        // String s = 4;


        char c = 'a';
        int num = 10;
        String str = "hello";
        System.out.println(c + num + str);//107hello
        System.out.println(c + str + num);//ahello10
        System.out.println((c + str) + num);//ahello10
        System.out.println(c + (num + str));//a10hello


        System.out.println("***********************");

        System.out.println('*' + '\t' + '*');
        System.out.println('*' + "\t" + '*');
        System.out.println('*' + '\t' + "*");
        System.out.println('*' + ('\t' + "*") + null + false);
        System.out.println("***********************");


        //格式化输出以及进制
        System.out.printf("%d ,%<b", 0xc);
        for (int i = 0; i < 255; i++) {
            System.out.print((char) i);
            if (i % 20 == 0) System.out.println();
        }

        int[] arr = new int[]{1, 2, 3};
        for (int i = 0; i < arr.length; i++) {

        }
    }
}