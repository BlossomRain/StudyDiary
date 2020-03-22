package com.iotest;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Auther: lxz
 * @Date: 2020/3/21 0021
 * @Description:节点流的输入输出测试
 */
public class FileReaderWriterTest {


    //读取文件       -->hello.txt
    @Test
    public void test() {
        String pathname = "hello.txt";
        FileReader fileReader = null;
        File file = null;
        try {
            file = new File(pathname);
            fileReader = new FileReader(file);

            int read;                                                   //读取一个字符
            while (-1 != (read = fileReader.read())) {
                System.out.print((char) read);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //读取文件,用buffer       -->hello.txt
    @Test
    public void test1() {
        String pathname = "hello.txt";
        FileReader fileReader = null;
        File file = null;
        try {
            file = new File(pathname);
            fileReader = new FileReader(file);

            char[] buffer = new char[1024];
            int len;
            while (-1 != ( len = fileReader.read(buffer))) {   //返回值为读取的个数,-1为EOF

                System.out.print(new String(buffer,0,len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //写出
    @Test
    public void test2(){
        String pathname = "hello.txt";
        FileWriter writer = null;
        File file = null;
        try {
            file = new File(pathname);
            writer = new FileWriter(file,true);

            String s = "Minecraft";
            writer.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
