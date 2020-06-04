package com.weibin.vm.refrence;

import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.util.Objects;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/5/23
 **/
public class SoftReferenceTest {

    public static void main(String[] args) {
        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<Object>(o);
        o = null;
        System.out.println(softReference.get());
        try {
            ByteBuffer allocate = ByteBuffer.allocate(1024 * 10 * 10);
            byte[] array = allocate.array();
            System.out.println(array.length);
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            System.out.println(o);
            System.out.println(softReference.get());
        }


    }


}
