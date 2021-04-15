package com.jiaxu.chat02;

public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkSend(6666,"localhost",8888),"学生").start();
        new Thread(new TalkReceive(9999),"老师").start();

    }
}
