package com.weibin.vm;

import java.util.concurrent.Callable;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/10
 **/
public class ReferenceTest implements Test {


    private int m;


    /* public ReferenceTest(){
        weakReference = new WeakReference <>(new ReferenceTest());
    }*/


    public static void main(String[] args) throws InterruptedException {
        byte i = (byte) Integer.MAX_VALUE;
        System.out.println("i2s :　" + i);
        /*ReferenceTest ye = new ReferenceTest();
        int compute = ye.compute();
        System.out.println(compute)*/;

    }

    int x = Integer.MAX_VALUE;

    int compute() {

        try {
            synchronized (this) {
                x += 1000;
            }

            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }


    public static class Reference implements Callable<Void> {

        @Override
        public Void call() throws Exception {
            return null;
        }
    }

}
