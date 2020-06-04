package com.review.buffer;

import java.nio.ByteBuffer;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/14
 **/
public class ByteBufferTest_2 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[]{1,2,3,4,5,6,7,8,9});
        buffer.position(5);
        buffer.compact();
        byte[] array = buffer.array();
        for (byte b : array){
            System.out.println("b : " + b);
        }
        System.out.println(array.length);
    }

}
