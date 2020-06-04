package com.weibin.thread;

import java.math.BigDecimal;
import java.util.concurrent.*;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/29
 **/
public class RuntimeTest {

    static final ThreadPoolExecutor executor = new ThreadPoolExecutor(
            1,2,10, TimeUnit.SECONDS,new SynchronousQueue<>());

    static final ThreadPoolExecutor executor1 = new ThreadPoolExecutor(
            1,2,10, TimeUnit.SECONDS,new SynchronousQueue<>());

    public static void main(String[] args) throws InterruptedException {

        VMExitHandlerHolder.register("a",executor);
        VMExitHandlerHolder.register("b",executor1);
        System.out.println(Runtime.getRuntime().availableProcessors());
        //Runtime.getRuntime().halt(0);
        Thread.sleep(5000);
    }

    public BigDecimal getBlance(){
        return new BigDecimal(0);
    }

    public void credit(BigDecimal amout){

    }



}
