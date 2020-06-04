package com.weibin.pattern;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/24
 **/
public class SingletonInstance {

    // 最好的单例模式
    public SingletonInstance getInstance(){
        return LazyHolder.instance;
    }

    private static final class LazyHolder{
        private static final SingletonInstance instance = new SingletonInstance();
    }

}
