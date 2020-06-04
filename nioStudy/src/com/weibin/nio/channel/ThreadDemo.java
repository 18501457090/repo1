package com.weibin.nio.channel;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo {



    public static void main(String[] args) throws InterruptedException {
        /*SyncImpl im = new SyncImpl();
        new Thread(()->{
            try {
                im.fun1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                im.fun2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();*/

        /*LockImpl im = new LockImpl();
        new Thread(()-> im.fun1()).start();
        new Thread(()-> im.fun2()).start();*/
        /*LockSupportImpl im = new LockSupportImpl();
        im.execute();*/
        CASImpl im = new CASImpl();
        new Thread(()->im.fun1()).start();
        new Thread(()->im.fun2()).start();

    }

    /* 使用synchronized关键字实现 */
    static class SyncImpl {

        synchronized void fun1() throws InterruptedException {
            for (int i = 1; i < 100; i += 2){
                System.out.println("奇数线程：" + i);
                this.notifyAll();
                this.wait();
            }
        }

        synchronized void fun2() throws InterruptedException {
            for (int i = 0; i < 100; i += 2){
                System.out.println("偶数线程：" + i);
                this.notifyAll(); // 唤醒其他线程
                this.wait(); // 挂起当前线程
            }
        }

    }

    /* 使用Lock实现 */
    static class LockImpl{
        // 设置标志
        private boolean flag = false;
        private Lock lock = new ReentrantLock();
        // 使用同一把锁定义条件通知对象
        private Condition condition1 = lock.newCondition();
        private Condition condition2 = lock.newCondition();

        void fun1() {
            lock.lock();
            try {
                //System.out.println("1 flag : " + flag);
                while (flag){
                    // 防止被意外唤醒,或者被唤醒时条件已经满足,
                    // 但唤醒后条件又不满足了。
                    condition1.await();
                }
                for (int i = 0; i < 100; i += 2){
                    Thread.sleep(100);
                    System.out.println("偶数线程：" + i);
                    condition2.signal();
                    flag = true;
                    condition1.await();
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        void fun2(){
            lock.lock();
            try {
                while (!flag){
                    condition2.await();
                }
                for (int i = 1; i < 100; i += 2){
                    Thread.sleep(100);
                    System.out.println("奇数线程：" + i);
                    condition1.signal();
                    flag = false;
                    condition2.await();
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    /* 使用LockSupport实现 */
    static class LockSupportImpl{

        private Thread thread = new MyThread1();
        private Thread thread2 = new MyThread2();

        void execute(){
            thread.start();
            thread2.start();
        }

        class MyThread1 extends Thread{
            @Override
            public void run() {
                for (int i = 0; i < 100;i += 2){
                    System.out.println("偶数线程 ： " + i);
                    LockSupport.unpark(thread2);
                    LockSupport.park();

                }
            }
        }
        class MyThread2 extends Thread{
            @Override
            public void run() {
                for (int i = 1; i < 100;i += 2){
                    System.out.println("奇数线程 ： " + i);
                    LockSupport.unpark(thread);
                    LockSupport.park();
                }
            }
        }



    }

    /* 使用CAS实现 */
    static class CASImpl{
        private final AtomicBoolean FLAG = new AtomicBoolean(false);
        private int num = 0;
        private int num1 = 1;
        void fun1(){
            while (!FLAG.get()){
                if (num >= 98){
                    break;
                }
                System.out.println("奇数线程 ： " + num);
                num += 2;
                FLAG.compareAndSet(true,false);

            }
        }

        void fun2(){
            while (FLAG.get()){
                if (num1 >= 99 && !FLAG.get()){
                    break;
                }
                System.out.println("偶数线程 ： " + num1);
                num1 += 2;
                FLAG.compareAndSet(false,true);

            }
        }


    }




}
