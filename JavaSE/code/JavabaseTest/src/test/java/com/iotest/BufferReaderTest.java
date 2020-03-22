package com.iotest;

import org.junit.Test;

import java.io.*;

/**
 * @Auther: lxz
 * @Date: 2020/3/22 0022
 * @Description:缓冲流测试
 */
public class BufferReaderTest {
    @Test
    public void test() {
        FileInputStream stream = null;
        BufferedInputStream bis = null;
        try {
            stream = new FileInputStream("hello.txt");
            bis = new BufferedInputStream(stream);

            byte[] buffer = new byte[1024];
            int len;

            while ((len = bis.read(buffer)) != -1) {
                System.out.println(buffer);     //会乱码
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (stream != null) {

                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
