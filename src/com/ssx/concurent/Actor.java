package com.ssx.concurent;

public class Actor extends Thread {


    @Override
    public void run() {
        System.out.println(getName()+"是一个演员！");
        int count=0;
        boolean keeorunning=true;
        while (keeorunning){
            System.out.println(getName()+"演出:"+(++count)+"次");
            if (count==100) keeorunning=false;
            if (count%10==0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(getName()+"演出结束了~");
    }

    public static void main(String[] args) {
        Thread actor=new Actor();
        actor.setName("Mr.thread");
        actor.start();

        Thread actressThread=new Thread(new Actress(),"Ms.Runnable");
        actressThread.start();
    }
}

class Actress implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"是一个演员！");
        int count=0;
        boolean keeorunning=true;
        while (keeorunning){
            System.out.println(Thread.currentThread().getName()+"演出:"+(++count)+"次");
            if (count==100) keeorunning=false;
            if (count%10==0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName()+"演出结束了~");
    }


}
