package com.stringTest;

/**
 * @Auther: lxz
 * @Date: 2020/3/18 0018
 * @Description:
 */
public class StringBufferTest {
    public static void main(String[] args) {
        String str = null;
        StringBuffer buffer = new StringBuffer();

        StringBuffer append = buffer.append(str);//null
        append.append(true);

        System.out.println(append);

        StringBuffer buffer1 = new StringBuffer(null);//匹配的是String参数的构造器

    }
}
