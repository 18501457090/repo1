package com.weibin.thread;
import	java.util.concurrent.locks.ReentrantLock;

import java.math.BigDecimal;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/1
 **/
public class SingleThreadTest {


    static final ExecutorService service = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Executors.unconfigurableExecutorService(executorService);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());

        service.execute(() -> {
            System.out.println("2222");
            service.execute(() -> {
                countDownLatch.countDown();
                System.out.println("11111");
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        ReentrantLock lock = new ReentrantLock();
        lock.tryLock(60,TimeUnit.SECONDS);


        SingleThreadTest threadTest = new SingleThreadTest();
        InterruptTest a = new InterruptTest();
        RuntimeTest b = new RuntimeTest();
        BigDecimal amount = new BigDecimal(0);
        // 线程A
        threadTest.transferMoney(a, b, amount);
        // 线程B
        threadTest.transferMoney(a, b, amount);


        System.out.println("main线程执行结束");
    }

    private static final Object tieLock = new Object();

    public void transferMoney(InterruptTest a, RuntimeTest b, BigDecimal amount) {
        synchronized (tieLock) {
            synchronized (a) {
                synchronized (b) {
                    if (a.getBlance().compareTo(new BigDecimal(0)) < 0) {
                        // .....
                    } else {
                        a.debit(amount);
                        b.credit(amount);
                    }
                }
            }
        }

    }

}
