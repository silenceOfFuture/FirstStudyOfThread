package com.ssx.concurent.racecondition;

public class EnergySystem {
    //    能量盒子，储存能量的地方
    private final double[] energyboxs;
    private final Object lockObj=new Object();


    /**
     * @param n            能量盒子的数量
     * @param initalEnergy 每个能量盒子初始含有的能量值
     */
    public EnergySystem(int n, double initalEnergy) {
        energyboxs = new double[n];
        for (int i = 0; i < energyboxs.length; i++) {
            energyboxs[i] = initalEnergy;
        }
    }

    /**
     * 能量的转移，从一个盒子到另一个盒子
     *
     * @param from   能量源
     * @param to     能量终点
     * @param amount 能量值
     */
    public void transfer(int from, int to, double amount) throws InterruptedException {
//        互斥
        synchronized (lockObj){
//            if (energyboxs[from] < amount) return;
            /**
             * white循环，保证条件不满足时任务都会被条件阻挡
             * 而不是继续竞争cpu资源
             */
            while (energyboxs[from]<amount){
                lockObj.wait();
            }
            System.out.println(Thread.currentThread().getName());
            energyboxs[from] -= amount;
            System.out.printf("从%d转移%10.2f单位能量到%d", from, amount, to);
            energyboxs[to] += amount;
            System.out.printf("能量总和：%10.2f%n", getTotalEnergies());
//          唤醒所有在lockObj对象上等待的线程
            lockObj.notifyAll();
        }


    }

    /**
     * 获取能量世界的能量总和
     * @return
     */
    public double getTotalEnergies() {
        double sum = 0;
        for (double amount : energyboxs) {
            sum += amount;
        }
        return sum;
    }

    /**
     * 能量盒子的长度
     * @return
     */
    public int getBoxAmount(){
        return energyboxs.length;
    }
}
