package com.jiaxu.lesson01;

import java.net.InetSocketAddress;

public class TestInetShocketAddress {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 8080);
        InetSocketAddress inetSocketAddress1 = new InetSocketAddress("172.0.0.1", 8080);
        System.out.println(inetSocketAddress);
        System.out.println(inetSocketAddress1);
        
        System.out.println(inetSocketAddress1.getAddress());
        System.out.println(inetSocketAddress1.getHostName());
        System.out.println(inetSocketAddress1.getPort());

    }
}
