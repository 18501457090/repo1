package com.weibin.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/29
 **/
public class VMExitHandlerHolder {

    public static void register(String key, ExecutorService executor){
        VMExitHandler.getInstance().register(key,executor);
    }



}
