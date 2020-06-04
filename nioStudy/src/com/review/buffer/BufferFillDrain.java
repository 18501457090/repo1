package com.review.buffer;
import	java.nio.CharBuffer;

import java.nio.CharBuffer;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/13
 **/
public class BufferFillDrain {

    private static int index;

    private static String[] strs = {"hello,word,family,we are,to,server,http,ftp.networkInterfaces"};

    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(100);

        while (fillBuffer(buffer));
        System.out.println("flip before limit : " + buffer.limit() + " " +
                "position : " + buffer.position() + " capacity : " + buffer.capacity());
        buffer.rewind();
        System.out.println("flip after limit : " + buffer.limit() + " " +
                "position : " + buffer.position() + " capacity : " + buffer.capacity());

       /* while (fillBuffer(cb)){
            System.out.println("before current index : " + cb.position() + "  capacity : " + cb.capacity());
            cb.flip();
            System.out.println("after current index : " + cb.position() + "  capacity : " + cb.capacity());
            drainBuffer(cb);
            cb.clear();
        }*/
    }

    private static void drainBuffer(CharBuffer buffer){
        while (buffer.hasRemaining()){
            System.out.println(buffer.get());
        }
        System.out.println();
    }

    private static boolean fillBuffer(CharBuffer buffer){
        if (index > buffer.length() || index > strs.length - 1){
            return false;
        }
        String str = strs[index++];
        for (int i = 0;i < str.length(); i++){
            buffer.put(str.charAt(i));
        }
        return true;
    }


}
