package com.ssx.concurent.stage;

public class Stage extends Thread {
    @Override
    public void run() {
        System.out.println("演出开始");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("大幕拉开");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("话说当年，乌江之战。。。");

        ArmyRunnable liubang_army=new ArmyRunnable();
        ArmyRunnable xiangyu_army=new ArmyRunnable();
        Thread liu=new Thread(liubang_army,"刘邦军");
        Thread xiang=new Thread(xiangyu_army,"项羽军");

        /*启动线程*/
        liu.start();
        xiang.start();

        /*线程休眠*/
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("双方激战时，突然冲出一个人影");

        Thread xiaohe=new KeyPersonThread();
        xiaohe.setName("萧何");
        System.out.println("萧何希望能结束战争，回复和平。");

        /*停止线程*/
        liubang_army.keepRunning=false;
        xiangyu_army.keepRunning=false;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        xiaohe.start();

        /*所有线程等待join的结束*/
        try {
            xiaohe.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("。。。战争结束，人民安居乐业，萧何做到了他的要求。");
    }

    public static void main(String[] args) {
        new Stage().start();
    }
}
