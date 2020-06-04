package com.weibin.nio.nio;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/12
 **/
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0 ; i < 1000; i ++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread thread1 = Thread.currentThread();
                    boolean interrupted = thread1.isInterrupted();
                    System.out.println("a : " + interrupted);
                    interrupted = Thread.interrupted();
                    System.out.println("b : " + interrupted);
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        thread.interrupt();
        boolean interrupted = thread.isInterrupted();
        System.out.println("c : " + interrupted);
        /*Thread.sleep(500);
        System.exit(1);*/

    }


}
