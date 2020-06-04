package com.weibin.vm;

import com.weibin.vm.classloading.NoInitialization;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/14
 **/
public class FieldOverwrite extends HeapOOP{

    public final int m = 2;

    public static void main(String[] args) {
        FieldOverwrite overwrite = new FieldOverwrite();
        System.out.println(overwrite.m);

    }

}
