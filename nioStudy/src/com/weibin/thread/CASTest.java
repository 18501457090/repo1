package com.weibin.thread;

import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/4
 **/
public class CASTest {

    static AtomicBoolean flag = new AtomicBoolean(false);

    public static void main(String[] args) {
        System.out.println("beginTime : " + new Date().toLocaleString());
        CASTest test = new CASTest();
        Thread t1 = new Thread(()->test.incrByTwo());
        Thread t2 = new Thread(()->test.incrByOne());
        t1.setName("casThread1");
        t2.setName("casThread2");
        t1.start();
        t2.start();
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("beginTime : " + new Date().toLocaleString());
        }));

    }

    void incrByTwo()  {
        for (int i = 0; i < 99; i += 2) {
            while (!flag.get());
            System.out.println(Thread.currentThread().getName() + "　　" + i);
            flag.compareAndSet(true,false);
        }
    }

    void incrByOne() {
        for (int i = 1; i < 100; i += 2) {
            while (flag.get());
            System.out.println(Thread.currentThread().getName() + "　　" + i);
            flag.compareAndSet(false,true);
        }

    }


}
