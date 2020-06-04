package com.weibin.vm.classloading;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/15
 **/
public class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    public static final String CONSTANT_1 = "hello";

}
