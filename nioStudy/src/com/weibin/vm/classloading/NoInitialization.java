package com.weibin.vm.classloading;

import com.weibin.vm.classloading.SubClass;
import com.weibin.vm.classloading.SuperClass;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/15
 **/
public class NoInitialization {

    public int[] arr = new int[10];

    public static void main(String[] args) {
        int i = InterfaceClass.instance.hashCode();

        System.out.println(ConstClass.CONSTANT_1);
    }

}
