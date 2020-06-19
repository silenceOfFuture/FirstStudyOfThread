package com.ssx.concurent.ticket;

class MyThread extends Thread {

    private int ticketCont=5;//一共5张票
    private String name;    //窗口（线程）名字

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (ticketCont>0){
            ticketCont--;   //如果还有票就卖掉一张
            System.out.println(name+"卖了一张票，剩余票数："+ticketCont);
        }
    }
}


public class TicketsThread {

    public static void main(String[] args) {

//        创建三个线程，模拟三个擦虹口买票
        MyThread m1=new MyThread("窗口1");
        MyThread m2=new MyThread("窗口2");
        MyThread m3=new MyThread("窗口3");

//        启动三个线程
        m1.start();
        m2.start();
        m3.start();

    }
}
