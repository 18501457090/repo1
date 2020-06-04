package com.weibin.vm.classloading;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/15
 **/
public class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init!");
    }

    public static void init(){
        System.out.println("子类初始化!");
    }

}
