package com.weibin.nio.channel;

import java.nio.Buffer;
import java.nio.CharBuffer;
import java.nio.channels.Channel;

public class CharAtMethodTest {


    public static void main(String[] args) {

        CharBuffer charBuffer = CharBuffer.allocate(10);
        charBuffer.append("abcdefg");
        charBuffer.position(2);
        System.out.println(charBuffer.charAt(0));
        System.out.println(charBuffer.charAt(1));
        System.out.println(charBuffer.charAt(2));
    }


}
