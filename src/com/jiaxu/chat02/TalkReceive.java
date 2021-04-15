package com.jiaxu.chat02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable{
    DatagramSocket datagramSocket = null;
    private int port;

    public TalkReceive(int port) {
        this.port = port;
        try {

            //端口
            datagramSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {


        while (true) {

            try {
                //接收数据

                byte[] contains = new byte[1024];


                DatagramPacket packet = new DatagramPacket(contains, 0, contains.length);


                datagramSocket.receive(packet);
                byte[] data = packet.getData();
                String recieiceDate = new String(data, 0, data.length);
                System.out.println(Thread.currentThread().getName()+":" +recieiceDate);

                if (recieiceDate.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //关闭流
        datagramSocket.close();
    }
}
