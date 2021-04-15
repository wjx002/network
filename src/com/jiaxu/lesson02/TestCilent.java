package com.jiaxu.lesson02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//客户端
public class TestCilent {
    public static void main(String[] args) {

        Socket socket = null;
        OutputStream os = null;
        try {

            //1.要知道服务器的地址，端口号
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int post = 9999;

            //2.创建一个socket连接
            socket = new Socket(serverIP, post);

            //3.发生消息   IO流
            os = socket.getOutputStream();
            os.write("你好，我就是太阳".getBytes());


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (os!=null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
