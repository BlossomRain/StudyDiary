package com.iotest;

import org.junit.Test;

import java.io.File;

/**
 * @Auther: lxz
 * @Date: 2020/3/21 0021
 * @Description:文件/文件夹的打开使用
 */
public class FileTest {

    @Test
    public void testExer(){

    }

    @Test
    public void testCreate() throws Exception{
        String pathName = "hello.txt";
        File file = new File(pathName);
        if (!file.exists()){
            boolean newFile = file.createNewFile();
        }else {
            file.delete();
        }
    }

    @Test
    public void testFile() {
        File file = new File("hello.txt");
        file = new File("parent", "child");
        file = new File(file, "hi.txt");
/*
        file = new File("hi.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(file.lastModified());*/

        //要有实际存在的路径
        File dir = new File("D:\\Program Files");
        String[] list = dir.list();
        for (String s : list) {
            System.out.println(s);
        }

        File[] files = dir.listFiles();
        for (File file1 : files) {
            System.out.println(file1);
        }
    }
}
