package com.weibin.thread;

import java.util.concurrent.*;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/5/21
 **/

public class ThreadPoolShutDownTest {



    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,
                2,1,TimeUnit.SECONDS,new LinkedBlockingQueue());
        long completedTaskCount = poolExecutor.getCompletedTaskCount();
        System.out.println("completedTaskCount ： " + completedTaskCount);
        VMExitHandlerHolder.register("poolExecutor",poolExecutor);
        //Thread.sleep(1000);
        System.exit(1);
    }

}
