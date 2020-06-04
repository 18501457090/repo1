package com.weibin.nio.channel;

import java.nio.CharBuffer;

public class AppendMethodTest {

    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.allocate(15);
        System.out.println("A : " + charBuffer.position());
        charBuffer.append('A');
        System.out.println("B : " + charBuffer.position());
        charBuffer.append("bcdefg");
        System.out.println("c : " + charBuffer.position());
        charBuffer.append("aa",2,2);
        System.out.println("d : " + charBuffer.position());
        char[] array = charBuffer.array();
        for (char c : array){
            System.out.print(c  + "  ");
        }

        System.out.println("capacity : " + charBuffer.capacity());

    }


}
