package com.review.buffer;

import java.nio.CharBuffer;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/20
 **/
public class ByteBufferFillAndClearTest {

    static private int index = 0;

    public static void main(String[] args) {
        CharBuffer allocate = CharBuffer.allocate(100);
        while (fillBuffer(allocate)){
            allocate.flip();
            drainBuffer(allocate);
            allocate.clear();
        }
    }

    private static void drainBuffer(CharBuffer byteBuffer){
        while (byteBuffer.hasRemaining()){
            System.out.print(byteBuffer.get());
        }
        System.out.println(" ");
    }

     synchronized private static boolean fillBuffer(CharBuffer buffer){
        if (index >= strings.length){
            return false;
        }
        String str = strings[index++];
        for (int i  = 0; i < str.length();i++){
            buffer.put(str.charAt(i));
        }
        return true;
    }

    private static String[] strings = {"111111222" +
            "3233243wewewwewdsdswee" +
            "sfsdfsdfsdfsdewefef233"};

}
