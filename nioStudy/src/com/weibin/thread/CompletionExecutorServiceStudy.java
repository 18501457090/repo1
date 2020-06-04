package com.weibin.thread;
import java.util.concurrent.*;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/30
 **/
public class CompletionExecutorServiceStudy {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        
        BlockingQueue  queue = new LinkedBlockingQueue();
        ExecutorCompletionService  service = new ExecutorCompletionService(pool,queue);
        service.submit(() -> {
            System.out.println("111");
            return "";
        });


    }

}
