package com.ssx.concurent.ticket;
//Runnable方式可以避免Thread方式由于java单继承特性带来的缺陷
//Runnable代码可以被多个线程共享，适用于多个线程处理同一资源的情况
class MyThread1 implements Runnable {

    private int ticketCont=5;//一共5张票

    @Override
    public void run() {
        while (ticketCont>0){
            ticketCont--;   //如果还有票就卖掉一张
            System.out.println(Thread.currentThread().getName()+"卖了一张票，剩余票数："+ticketCont);
        }
    }
}

public class TicketsRunnable {

    public static void main(String[] args) {

        MyThread1 m=new MyThread1();
        Thread t1=new Thread(m,"窗口1");
        Thread t2=new Thread(m,"窗口2");
        Thread t3=new Thread(m,"窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
