package com.jiaxu.lesson04;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//接收端
public class Server {
    public static void main(String[] args) throws Exception {

        //开放端口
        DatagramSocket datagramSocket = new DatagramSocket(9999);



        //接收数据
        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);

        //最终接收
        datagramSocket.receive(datagramPacket);
        System.out.println(datagramPacket.getAddress().getHostAddress());
        System.out.println(new String(datagramPacket.getData()));

        //关闭流
        datagramSocket.close();
    }
}
