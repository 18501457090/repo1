package com.weibin.thread;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/9
 **/
public class SafeLazyInitialization {

    private static SafeLazyInitialization initialization = new SafeLazyInitialization();

    public  static SafeLazyInitialization getInstance(){
        return initialization;
    }


}
