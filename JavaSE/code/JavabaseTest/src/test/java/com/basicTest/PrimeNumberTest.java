package com.basicTest;

import org.junit.Test;

/**
 * @Auther: lxz
 * @Date: 2020/3/9 0009
 * @Description:输出100以内质数的算法逐步优化
 */
public class PrimeNumberTest {
    @Test
    public void test1() {
        int i, j;
        boolean flag = true;        //用于判断是否被整除

        for (i = 2; i < 100; i++) {
            for (j = 2; j < i && flag == true; j++) {
                if (i % j == 0) {
                    flag = false;
                }
            }
            if (flag == true) {
                System.out.println(i);
            }
            flag = true;
        }
    }

    @Test
    public void test2() {
        int i, j, count = 0;
        boolean flag = true;                        //用于判断是否被整除

        long begin = System.currentTimeMillis();
        for (i = 2; i < 100000; i++) {
            for (j = 2; j <= Math.sqrt(i) && flag == true; j++) {//只对非质数有效  没优化240
                //优化  40
                if (i % j == 0) {
                    flag = false;
                }
            }
            if (flag == true) {
                // System.out.print("");
                count++;
            }
            flag = true;
        }
        System.out.println();


        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    @Test
    public void test3() {
        int i, j, count = 0;
        //用于判断是否被整除

        long begin = System.currentTimeMillis();
        label:
        for (i = 2; i < 100000; i++) {
            for (j = 2; j <= Math.sqrt(i); j++) {//只对非质数有效  没优化240
                //优化  40
                if (i % j == 0) {
                    continue label;
                }
            }
            count++;

        }


        long end = System.currentTimeMillis();
        System.out.println(count + "----------" +( end - begin));
    }
}
