package com.weibin.nio.channel;

import java.nio.ByteBuffer;

public class DuplicateMethodTest {

    public static void main(String[] args) {
        byte[] byteArray = {1,2,3,4,5} ;
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        byteBuffer.position(2);
        byteBuffer.limit(4);
        ByteBuffer slice = byteBuffer.slice();
        ByteBuffer duplicate = byteBuffer.duplicate();
        System.out.println("-- - - -- --- - - -- - - - - -- - - - - - - -");
        System.out.println( "slice-->position() : " + slice.position() + "  slice--->remaining : " + slice.remaining()
                + " slice-->limit() : " + slice.limit() + "   slice.capacity() : " + slice.capacity());
        System.out.println("duplicate-->position() : " + duplicate.position() + "  duplicate--->remaining : " + duplicate.remaining()
                + " duplicate-->limit() : " + duplicate.limit() + "   duplicate.capacity() : " + duplicate.capacity());


    }


}
