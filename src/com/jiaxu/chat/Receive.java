package com.jiaxu.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.BreakIterator;

//接收
public class Receive {
    public static void main(String[] args) throws Exception {

        //端口
        DatagramSocket datagramSocket = new DatagramSocket(6666);

        while (true) {

            //接收数据

            byte[] contains = new byte[1024];


            DatagramPacket packet = new DatagramPacket(contains, 0, contains.length);


            datagramSocket.receive(packet);
            byte[] data = packet.getData();
            String recieiceDate = new String(data, 0, data.length);
            System.out.println(recieiceDate);

            if (recieiceDate.equals("bye")) {
                break;
            }
        }

        //关闭流
        datagramSocket.close();

    }
}
