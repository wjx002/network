package com.jiaxu.chat02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class TalkSend implements Runnable {

    DatagramSocket datagramSocket = null;
    BufferedReader reader = null;
    private int MyPort;
    private String MyAddress;
    private int ToPort;

    public TalkSend(int myPort, String myAddress, int toPort) {
        MyPort = myPort;
        MyAddress = myAddress;
        ToPort = toPort;
        try {
            //建立socket
            datagramSocket = new DatagramSocket(MyPort);

            //数据 控制台输入
            //控制台输入
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true) {
            try {
                String data = reader.readLine();
                byte[] datas = data.getBytes();

                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(this.MyAddress, this.ToPort));
                //发送包
                datagramSocket.send(packet);

                if (data.equals("bye")) {
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
