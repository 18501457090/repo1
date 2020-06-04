package com.weibin.thread;

import java.util.Date;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/4
 **/
public class LockTest {

    static final Object lock = new Object();
    static boolean isRun = false;

    public static void main(String[] args) {
        System.out.println("begin : " + new Date().toLocaleString());
        LockTest test = new LockTest();
        Thread t1 = new Thread(() -> {
            try {
                test.incrByOne();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                test.incrByTwo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.setName("T1");
        t2.setName("T2");
        t1.start();
        t2.start();
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("end : " + new Date().toLocaleString());
        }));
    }


    void incrByTwo() throws InterruptedException {
        synchronized (lock) {
            while (isRun) {
                lock.wait();
            }
            for (int i = 0; i < 100; i += 2) {
                System.out.println(Thread.currentThread().getName() + "  " + i);
                isRun = true;
                if (i == 98){
                    lock.notifyAll();
                    System.out.println("tt break");
                    break;
                }
                lock.notifyAll();
                lock.wait();
            }
        }
    }

    void incrByOne() throws InterruptedException {
        synchronized (lock) {
            while (!isRun) {
                lock.wait();
            }
            for (int i = 1; i < 100; i += 2) {
                System.out.println(Thread.currentThread().getName() + "  " + i);
                isRun = false;
                if (i == 99){
                    lock.notifyAll();
                    System.out.println("aa break");
                    break;
                }
                lock.notifyAll();
                lock.wait();
            }
        }

    }
}
