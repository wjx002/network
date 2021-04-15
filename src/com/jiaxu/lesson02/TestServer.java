package com.jiaxu.lesson02;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务器端
public class TestServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream byteArrayOutputStream = null;

        try {
            //1.我有一个地址
            serverSocket = new ServerSocket(9999);
            while (true) {
                //2.等待客户端连接过来
                socket = serverSocket.accept();
                //读取客户端的消息
                is = socket.getInputStream();

                //管道流
                byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer,0,len);
                }
                System.out.println(byteArrayOutputStream.toString());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (byteArrayOutputStream!=null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket!=null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
