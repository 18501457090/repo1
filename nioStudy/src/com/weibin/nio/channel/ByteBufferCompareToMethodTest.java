package com.weibin.nio.channel;

import java.nio.ByteBuffer;

public class ByteBufferCompareToMethodTest {


    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.wrap(new byte[]{1,2,3,4,5,6,7});
        ByteBuffer buffer1 = ByteBuffer.wrap(new byte[]{2,3,4,5,6,7});
        int min = Math.min(buffer.remaining(), buffer1.remaining());
        System.out.println("min : " + min);
        System.out.println("position : " + buffer.position());
        int n = buffer.position() + min;
        System.out.println("n : " + n);
        for (int i = buffer.position(), j = buffer1.position(); i < n; i++, j++) {
            int cmp = Byte.compare(buffer.get(i), buffer1.get(j));
            if (cmp != 0){
                System.out.println("cmp : " + cmp);
            }
        }
        System.out.println( buffer.remaining() - buffer1.remaining());

        /*System.out.println(min);
        buffer.get();
        System.out.println(buffer.compareTo(buffer1));*/


    }

}
