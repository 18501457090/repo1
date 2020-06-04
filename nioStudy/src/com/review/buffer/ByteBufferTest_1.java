package com.review.buffer;

import java.nio.ByteBuffer;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/14
 **/
public class ByteBufferTest_1 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[]{1, 23, 4, 56, 127});
        buffer.position(2);
        System.out.println("isReadOnlyBuffer ? " + buffer.isReadOnly());
        ByteBuffer byteBuffer = buffer.asReadOnlyBuffer();
        System.out.println("isReadOnlyBuffer ? " + byteBuffer.isReadOnly());
        System.out.println("new position : " + byteBuffer.position());
    }

}
