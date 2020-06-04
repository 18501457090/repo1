package com.weibin.nio.selector;

import java.util.Deque;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/27
 **/
public class Singleton {

    private static Singleton INSTANCE ;

    public static void main(String[] args) {

        Test test = new Test();
        for (int i = 0 ;i < 1000; i++){
            new Thread(test).start();
        }

    }

    static class Test implements Runnable{

        @Override
        public void run() {
            Singleton.getInstance();
        }
    }

    public static Singleton getInstance() {
        if (INSTANCE == null){
            synchronized (Singleton.class){
                if (INSTANCE == null){
                    System.out.println("初始化了一次!!!");
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

}
