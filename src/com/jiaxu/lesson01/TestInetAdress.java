package com.jiaxu.lesson01;

import java.net.InetAddress;
import java.net.UnknownHostException;

//测试IP
public class TestInetAdress {
    public static void main(String[] args) {
        try {
            //查询本机地址
            InetAddress inetAddress = InetAddress.getByName("172.0.0.1");
            System.out.println(inetAddress);
            InetAddress inetAddress2 = InetAddress.getByName("localhost");
            System.out.println(inetAddress2);
            InetAddress inetAddress3 = InetAddress.getLocalHost();
            System.out.println(inetAddress3);

            //查询网站ip地址
            InetAddress inetAddress1 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress1);

            System.out.println(inetAddress1.getAddress());
            System.out.println(inetAddress1.getCanonicalHostName());
            System.out.println(inetAddress1.getHostAddress());
            System.out.println(inetAddress1.getHostName());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
