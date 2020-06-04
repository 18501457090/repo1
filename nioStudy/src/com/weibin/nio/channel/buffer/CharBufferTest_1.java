package com.weibin.nio.channel.buffer;

import java.io.IOException;
import java.nio.CharBuffer;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/14
 **/
public class CharBufferTest_1 {

    public static void main(String[] args) throws IOException {
        CharBuffer buffer = CharBuffer.wrap(new char[]{'a','b','c','d','e'});
        buffer.position(4);
        System.out.println("position : " + buffer.position());
        buffer.flip();
        while (buffer.hasRemaining()){
            System.out.print(buffer.get());
        }

    }


}
