package com.weibin.thread;

import java.util.Date;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/4
 **/
public class VolatileTest {

    static volatile boolean flag = false;

    public static void main(String[] args) {
        System.out.println("beginTime : " + new Date().toLocaleString());
        VolatileTest test = new VolatileTest();
        Thread t1 = new Thread(()->test.incrByTwo());
        Thread t2 = new Thread(()->test.incrByOne());
        t1.setName("volatileThread1");
        t2.setName("volatileThread2");
        t1.start();
        t2.start();
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("beginTime : " + new Date().toLocaleString());
        }));
    }



    void incrByTwo()  {
        for (int i = 0; i < 99; i += 2) {
            while (!flag);
            System.out.println(Thread.currentThread().getName() + "　　" + i);
            flag = false;
        }
    }

    void incrByOne() {
        for (int i = 1; i < 100; i += 2) {
            while (flag);
            System.out.println(Thread.currentThread().getName() + "　　" + i);
            flag = true;
        }

    }

}
