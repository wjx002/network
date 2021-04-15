package com.jiaxu.lesson03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class Server {
    public static void main(String[] args) throws Exception {
        //创建服务
        ServerSocket serverSocket = new ServerSocket(9000);

        //监听器
        Socket socket = serverSocket.accept();

        //获取输入流
        InputStream inputStream = socket.getInputStream();

        //文件输出
        FileOutputStream fileOutputStream = new FileOutputStream(new File("456.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read()) != -1) {
            fileOutputStream.write(buffer, 0, len);
        }

        //通知客户端我接收完毕
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我接收完了，你可以断开了".getBytes());

//        关闭资源
        outputStream.close();
        fileOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
