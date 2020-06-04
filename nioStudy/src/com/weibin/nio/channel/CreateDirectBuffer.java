package com.weibin.nio.channel;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class CreateDirectBuffer {


    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(10);
        IntBuffer intBuffer = buffer.asIntBuffer();
        // 由于ByteBuffer是直接缓冲区，效率比较快。
        // 所以IntBuffer也是直接缓冲区
        System.out.println(intBuffer);
        System.out.println(intBuffer.isDirect());
    }

}
