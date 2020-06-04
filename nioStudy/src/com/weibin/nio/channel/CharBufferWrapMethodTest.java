package com.weibin.nio.channel;

import java.nio.CharBuffer;

public class CharBufferWrapMethodTest {

    public static void main(String[] args) {
        CharBuffer wrap = CharBuffer.wrap("abcdefg", 0, 2);
        System.out.println("position : " + wrap.position() + " limit : " +
                wrap.limit() + " capacity ： " + wrap.capacity());
        wrap.length();
        for (int i = 0 ; i < wrap.limit(); i++){
            System.out.print(wrap.get(i) + "   ");
        }


    }


}
