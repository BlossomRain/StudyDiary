package com.netTest;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Auther: lxz
 * @Date: 2020/3/22 0022
 * @Description:网络编程测试
 */
public class NetTest {

    //TCP编程 测试 客户端发送数据
    @Test
    public void testClient() {
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            InetAddress byName = InetAddress.getByName("127.0.0.1");

            socket = new Socket(byName, 12345);
            os = socket.getOutputStream();

            os.write("Hello,i am client".getBytes());
            //关闭传输
            socket.shutdownOutput();
             is = socket.getInputStream();
             baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[20];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                is.close();
                baos.close();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    //服务端  接收数据
    @Test
    public void testServer() {
        ServerSocket ser = null;
        Socket accept = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        OutputStream os = null;
        try {
            ser = new ServerSocket(12345);
            accept = ser.accept();

            is = accept.getInputStream();

            baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[10];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            os = accept.getOutputStream();
            os.write("数据已接收".getBytes());//反馈
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                baos.close();
                is.close();
                os.close();
                accept.close();
                ser.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    //InetAddress 测试
    @Test
    public void testNet() throws UnknownHostException {

        InetAddress name = InetAddress.getByName("baidu.com");
        System.out.println(name);

        String hostAddress = name.getHostAddress();
        String add = name.getHostAddress();

    }


}
