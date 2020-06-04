package com.weibin.vm.pattern;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/20
 **/
public class Singleton {

    private static class InnerClass{
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getSingleInstance() {
        return InnerClass.instance;
    }



}
