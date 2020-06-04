package com.weibin.thread;
import java.math.BigDecimal;
import	java.util.concurrent.SynchronousQueue;
import java.util.concurrent.*;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/29
 **/
public class InterruptTest {


    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        Thread t1 = new Thread(a);
        CyclicBarrier cb = new CyclicBarrier(12);
        Exchanger<Integer> exchanger = new Exchanger<Integer> ();
        t1.start();

        Executors.newCachedThreadPool();

        SynchronousQueue<Integer> synchronousQueue =
                new SynchronousQueue<>();

        Thread.sleep(100);
        t1.interrupt();
    }

    public void debit(BigDecimal amout){

    }

    public BigDecimal getBlance(){
        return new BigDecimal(0);
    }

    static class A implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("监听到中断事件的发生,中断当前线程!!!");
                    break;
                } else {
                    System.out.println("是否中断 ? : " + Thread.currentThread().isInterrupted());
                }

            }
        }
    }


}
