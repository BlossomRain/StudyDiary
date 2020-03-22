package com.basicTest;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: lxz
 * @Date: 2020/3/11 0011
 * @Description:数组的使用例子
 */
public class ArrayTest {

    @Test  //   数组可存放基本类型和引用类型 初始化 杨辉三角
    public void test1() {
        //静态初始化
//        int[] arr1 = new int[]{};
//        //动态初始化
//        int[] arr2 = new int[1];
        int[][] yangHui = new int[10][];

        for (int i = 0; i < yangHui.length; i++) {
            //赋值
            yangHui[i] = new int[i + 1];
            //边框
            yangHui[i][0] = yangHui[i][i] = 1;

            for (int j = 1; j < yangHui[i].length - 1; j++) {
                yangHui[i][j] = yangHui[i - 1][j - 1] + yangHui[i - 1][j];
            }

        }

        for (int i = 0; i < yangHui.length; i++) {
            for (int j = 0; j < yangHui[i].length; j++)
                System.out.print(yangHui[i][j] + " ");
            System.out.println();
        }

    }

    @Test   //  数组的复制是浅复制,实现数组反转
    public void test2() {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    @Test   //  Arrays工具类的使用例子
    public void test3(){
        int[] ints = {12, 34, 36, 65, 7, 8, 98, 6545, 534, 21, 1, 5, 43, 65443, 2, 546, 546};
        int[] ints2 = new int[]{12, 34, 36, 65, 7, 8, 98, 6545, 534, 21, 1, 5, 43, 65443, 2, 546, 54};
        Arrays.sort(ints);
        Arrays.equals(ints,ints2);

    }
}
