package com.weibin.vm.classloading;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/15
 **/
public class SuperClass {

    static {
        System.out.println("SuperClass init");
    }
    public static int value = 123;

}
