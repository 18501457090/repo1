package com.weibin.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/5/6
 **/
public class LockSupportDemo {



    static final class ThreadTest extends Thread{

        public ThreadTest(String name){
            super(name);
        }

        @Override
        public void run() {
            synchronized (LockSupportDemo.class){
                System.out.println("ThreadName : " + Thread.currentThread().getName());
                LockSupport.park();
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("中断了 ： " + Thread.currentThread().isInterrupted());
                }
                System.out.println("parkEnd!" + Thread.currentThread().getName());
            }

        }
    }

    public static void main(String[] args) {
        ThreadTest t1 = new ThreadTest("t1");
        ThreadTest t2 = new ThreadTest("t2");
        t1.start();
        //t1.interrupt();
        t2.start();
        LockSupport.unpark(t2);
        LockSupport.unpark(t1);

    }

}
