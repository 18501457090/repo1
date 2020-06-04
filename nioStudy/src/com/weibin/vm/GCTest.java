package com.weibin.vm;

import java.nio.ByteBuffer;

/**
 * sz
 *
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/16
 **/
public class GCTest {

    public static void main(String[] args) {
        int c = c();
        System.out.println(c);
    }

    static int c() {

        System.out.println(1 / 0);

        return 2;

    }


}
