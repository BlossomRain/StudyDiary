package com.iotest;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * @Auther: lxz
 * @Date: 2020/3/22 0022
 * @Description:缓冲流测试
 */
public class BufferReaderTest {

    public static void main(String[] args){
        testSystemIO();
    }

    //标准输入输出流,读取字符并打印

    public static void testSystemIO(){

        InputStreamReader read = null;
        BufferedReader reader = null;
        try {
            read = new InputStreamReader(System.in);
            reader = new BufferedReader(read);

            while (true){
                String s = reader.readLine();
                if ("e".equalsIgnoreCase(s)||"exit".equalsIgnoreCase("s")){
                    break;
                }
                System.out.println(s);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                read.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    //转换流
    @Test
    public void testInputStream() throws FileNotFoundException {
//        FileInputStream fileInputStream = new FileInputStream("hello.txt");
//        InputStreamReader reader = new InputStreamReader(fileInputStream, Charset.defaultCharset());
        SortedMap<String, Charset> map = Charset.availableCharsets();
        for (String s : map.keySet()) {
            System.out.println(s);
        }


    }



   //获取每个字符出现的次数
   @Test
   public void testExer() throws FileNotFoundException {
       FileReader reader = null;
       Map<Character,Integer> map=null;
       try {
           reader = new FileReader("hello.txt");

           int read ;
           map = new HashMap<>();

           while ((read = reader.read()) != -1){
               if (map.containsKey(read)){
                   map.put((char)read,map.get(read)+1);
               }else {
                   map.put((char)read,1);
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           try {
               if (reader != null)
               reader.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }

       Set<Map.Entry<Character, Integer>> entries = map.entrySet();
       for (Map.Entry<Character, Integer> o :entries ) {
           System.out.println(o.getKey()+"-->"+o.getValue());
       }
   }


   //
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
                System.out.println(buffer.toString());     //会乱码
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
