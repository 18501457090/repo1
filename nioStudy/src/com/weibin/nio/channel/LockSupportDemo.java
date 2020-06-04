package com.weibin.nio.channel;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

    public static void main(String[] args) {
        char[] arr = new char[]{'a','b','c','d'};
        int[] numArr = new int[]{1,2,3,45};

        Thread t1,t2 = null;
        t1 = new Thread(()->{
            for (int i : numArr){
                System.out.println(i);
                LockSupport.park();
                //LockSupport.unpark(t2);

            }
        });

        t2 = new Thread(()->{
            for (char i : arr){
                System.out.println(i);
                LockSupport.unpark(t1);
                LockSupport.park();
            }
        });




    }

}
