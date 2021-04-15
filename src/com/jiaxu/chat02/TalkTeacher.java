package com.jiaxu.chat02;

public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkSend(5555,"localhost",9999),"老师").start();
        new Thread(new TalkReceive(8888),"学生").start();
    }
}
