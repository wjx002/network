package com.jiaxu.lesson04;

import java.net.*;

//发送端
public class Client {
    public static void main(String[] args) throws Exception {
        //1.建立一个socket
        DatagramSocket datagramSocket = new DatagramSocket();

        //建一个包
        String msg = "你好服务端";
            //发送给谁
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9999;
        DatagramPacket packet = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,localhost,port);

        //发送包
        datagramSocket.send(packet);

        //关闭流
        datagramSocket.close();



    }
}
