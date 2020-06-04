package com.weibin.nio.channel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelWriteAppointTest {

    public static void main(String[] args) throws IOException {
        System.out.println("abcde               abcde".length());
        FileOutputStream instance1 = FileChannelFactory.getInstance("D:\\Channel\\Data\\write\\AppointTest_1.txt");
        FileChannel instance = instance1.getChannel();
        ByteBuffer buffer = ByteBuffer.wrap("abcde".getBytes());
        instance.write(buffer);
        System.out.println("rewind before position : " + buffer.position() + " limit : " + buffer.limit() + " capacity: " + buffer.capacity());
        buffer.rewind();
        System.out.println("rewind after position : " + buffer.position() + " limit : " + buffer.limit() + " capacity: " + buffer.capacity());
        instance.write(buffer,20);
        System.out.println("C fileChannel.position() : " + instance.position());
        instance.close();
        instance1.close();
    }

}
