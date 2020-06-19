package com.ssx.concurent.productThread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

class DemoThread implements Runnable{

    @Override
    public void run() {
        System.out.println("程序进入守护线程"+Thread.currentThread().getName());

        try {
            writeToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("退出了守护线程"+Thread.currentThread().getName());
    }

    private void writeToFile() throws Exception{
        File filename=new File("E:"+File.separator+"demo.txt");
        OutputStream os=new FileOutputStream(filename,true);
        int count=0;
        while (count<999){
            os.write(("\r\nnum"+count).getBytes());
            System.out.println("守护线程"+Thread.currentThread().getName()
            +"向文件写入了num"+count++);
            Thread.sleep(1000);
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("进入主线程"+Thread.currentThread().getName());

        DemoThread demoThread=new DemoThread();
        Thread thread=new Thread(demoThread);
        thread.setDaemon(true);
        thread.start();

        Scanner sc=new Scanner(System.in);
        sc.next();

        System.out.println("退出主线程"+Thread.currentThread().getName());
    }
}
