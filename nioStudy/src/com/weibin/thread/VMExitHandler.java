package com.weibin.thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/29
 **/
public final class VMExitHandler extends Thread {

    private static final ConcurrentHashMap<String, ExecutorService> pools =
            new ConcurrentHashMap<>(16);

    /**
     * 如果不需要等待任务执行完毕后再关闭线程池，传值为true
     * 如果需要等待线程池中的任务执行完毕再关闭，传值为false。
     * */
    private final boolean isShutDownNow;

    private VMExitHandler(boolean isShutDownNow) {
        this.isShutDownNow = isShutDownNow;
        Runtime.getRuntime().addShutdownHook(this);
    }

    public void register(String key, ExecutorService executor) {
        pools.putIfAbsent(key, executor);
    }

    public ExecutorService get(String key) {
        return pools.get(key);
    }

    public static VMExitHandler getInstance() {
        return Inner.INSTANCE;
    }

    @Override
    public void run() {
        this.close();
    }

    private void close() {
        System.out.println("关闭线程池！！");
        pools.forEach((k, v) -> {
            if (v != null) {
                if (!v.isShutdown()) {
                    if (this.isShutDownNow){
                        v.shutdownNow();
                    } else {
                        v.shutdown();
                    }
                    System.out.
                            println("当前线程池名称为：" + k + "----->是否已经被关闭 ： " +
                                    v.isTerminated());
                } else {
                    System.out.println("当前线程池名称为：" + k + "----->是否已经被关闭 ： " +
                            v.isTerminated());
                    pools.remove(k);
                }
            } else {
                pools.remove(k);
            }
        });
    }

    private static final class Inner {
        private static final VMExitHandler INSTANCE = new VMExitHandler(false);
    }

}
