package com.jiaxu.lesson03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

//TCP文件上传
//客户端
public class Client {
    public static void main(String[] args) throws Exception {

        //创建端口
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
        //创建输出流
        OutputStream os = socket.getOutputStream();

        //读取文件
         FileInputStream fileInputStream = new FileInputStream(new File("123.jpg"));

        //写出文件 让服务端接收
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fileInputStream.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }

        //告诉服务端发送完毕
        socket.shutdownOutput();//输出完毕

        //接收完毕
        InputStream inputStream = socket.getInputStream();

        //String byte[]
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;

        while ((len2 = inputStream.read(buffer)) != -1) {
            baos.write(buffer,0,len2);
        }
        System.out.println(baos.toString());

        //关闭资源
        baos.close();
        inputStream.close();
        fileInputStream.close();
        os.close();
        socket.close();
    }
}
