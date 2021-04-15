package com.jiaxu.chat;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

//发送
public class Sender {
    public static void main(String[] args) throws Exception {
        //建立socket
        DatagramSocket datagramSocket = new DatagramSocket(8888);

        //数据 控制台输入
        //控制台输入
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String data = reader.readLine();
            byte[] datas = data.getBytes();

            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 6666));
            //发送包
            datagramSocket.send(packet);

            if (data.equals("bye")) {
                break;
            }
        }

        //关闭流
        datagramSocket.close();
    }
}
