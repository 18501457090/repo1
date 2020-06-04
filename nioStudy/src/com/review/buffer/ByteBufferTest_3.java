package com.review.buffer;

import java.nio.ByteBuffer;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/14
 **/
public class ByteBufferTest_3 {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[]{1, 2, 34, 5, 6, 7, 8, 9});
        byteBuffer.position(2);
        byteBuffer.limit(6);
        ByteBuffer slice = byteBuffer.slice();
        System.out.println("通过slice()方法复制的新缓冲区,其position为："
                + slice.position() + "---->其limit为：" + slice.limit() + " ------> 其capacity为：" + slice.capacity());
        ByteBuffer duplicate = byteBuffer.duplicate();
        System.out.println("通过duplicate()方法复制的新缓冲区,其position为："
                + duplicate.position() + "---->其limit为：" + duplicate.limit() +
                " ------> 其capacity为：" + duplicate.capacity());
    }

}
