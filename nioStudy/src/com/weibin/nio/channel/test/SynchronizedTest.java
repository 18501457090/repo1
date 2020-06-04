package com.weibin.nio.channel.test;
import	java.util.Date;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/24
 **/
public class SynchronizedTest {

    private static final CountDownLatch cdl = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(a);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        System.out.println("阻塞 ： " + new Date().toLocaleString());
//        cdl.await();
        Thread.sleep(1000);
        System.out.println("线程2开始启动：" + new Date().toLocaleString());
        t2.start();
        System.out.println("线程2启动结束：" + new Date().toLocaleString());
        t2.interrupt();


    }

    static class A implements Runnable{


        @Override
        public void run() {
            try {
                synchronized (A.class){
//                    cdl.countDown();
                    System.out.println("ThreadName : " + Thread.currentThread().getName() + " " +
                            "" + new Date().toLocaleString());
                    Thread.sleep(5000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
