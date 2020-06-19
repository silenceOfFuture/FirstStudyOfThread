package com.ssx.concurent.stage;

/*军队线程，模拟双方军队行为*/
public class ArmyRunnable implements Runnable {
    /*volatile保证了线程正确读取其他线程写入的值
    * 可见性*/
    volatile boolean keepRunning=true;
    @Override
    public void run() {

        while (keepRunning){
            for (int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"进攻对方"+i+"次");
                /*让出处理器时间，下次谁进攻未定*/
                Thread.yield();
            }
        }

        System.out.println(Thread.currentThread().getName()+"结束了战斗！");
    }
}
