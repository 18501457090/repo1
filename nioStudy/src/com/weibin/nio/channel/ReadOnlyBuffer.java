package com.weibin.nio.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ReadOnlyBuffer {


    public static void main(String[] args) throws FileNotFoundException {
        byte[] bytes = {1,2,3,4,5};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        byteBuffer.get();
        ByteBuffer byteBuffer1 = byteBuffer.asReadOnlyBuffer();
        System.out.println(byteBuffer1.isReadOnly());
        // 只能读，不能修改
        //byteBuffer1.putInt(1);
        int remaining = byteBuffer1.remaining();
        System.out.println(remaining);

    }

}
