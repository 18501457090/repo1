package com.weibin.vm;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/10
 **/
public class ReferenceCounting {

    private static Object instance = new Integer(0);

    private static SoftReference<Object> softReference = new SoftReference<>(instance);

    public static void main(String[] args) {
        Object o = softReference.get();

        ReferenceCounting countingA = new ReferenceCounting();
        ReferenceCounting countingB = new ReferenceCounting();
        countingA.instance = countingB;
        countingB.instance = countingA;
        countingA = null;
        countingB = null;
        System.gc();

    }

}
