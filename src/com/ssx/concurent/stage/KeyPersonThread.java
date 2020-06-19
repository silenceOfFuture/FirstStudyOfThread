package com.ssx.concurent.stage;

public class KeyPersonThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始了战斗！");
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"率领军队开始厮杀。。。");
        }


        System.out.println(Thread.currentThread().getName()+"结束了战斗！");

    }
}
