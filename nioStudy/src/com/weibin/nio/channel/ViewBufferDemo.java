package com.weibin.nio.channel;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class ViewBufferDemo {

    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(10);
        boolean direct = allocate.isDirect();
        System.out.println(direct);
        System.out.println("A1 = " + allocate.position());
        allocate.putInt(123);
        System.out.println("A2 = " + allocate.position());
        allocate.putInt(456);
        System.out.println("A3 = " + allocate.position());

        IntBuffer intBuffer1 = allocate.asIntBuffer();
        System.out.println(intBuffer1);

        System.out.println(" -- -- --  -- - - -- - -- --- - - -");
        IntBuffer intBuffer = IntBuffer.allocate(10);
        System.out.println("A1 = " + intBuffer.position());
        intBuffer.put(123);
        System.out.println("A2 = " + intBuffer.position());
        intBuffer.put(456);
        System.out.println("A3 = " + intBuffer.position());

    }



}
