package com.weibin.pattern;

import java.lang.ref.SoftReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executors;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/21
 **/
public class SynchronizedSingleton {

    // 为什么使用volatile来进行修饰？
    private static volatile SynchronizedSingleton synchronizedSingleton;


    public static SynchronizedSingleton getInstance() {
        if (synchronizedSingleton == null) {
            synchronized (SynchronizedSingleton.class) {
                if (synchronizedSingleton == null) { //这里为什么要再做一次检查？
                    synchronizedSingleton = new SynchronizedSingleton();
                }
            }
        }
        return synchronizedSingleton;
    }

    private static class SynchronizedSingletonHolder {
        private static final SynchronizedSingleton singleton = new SynchronizedSingleton();
    }

    public static SynchronizedSingleton getInstance1() {
        return SynchronizedSingletonHolder.singleton;
    }

    public static void main(String[] args) throws MalformedURLException {
        SynchronizedSingleton.getInstance1();


    }

}
