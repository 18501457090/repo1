package com.weibin.nio.channel;
import java.io.IOException;
import	java.nio.ByteBuffer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class FileTest_1 {

    public static void main(String[] args) throws IOException {
        FileOutputStream instance = FileChannelFactory.getInstance("D:\\Channel\\Data\\write\\AppointTest_2.txt");
        FileChannel fileChannel = instance.getChannel();
        ByteBuffer buffer1 = ByteBuffer.wrap("abcde".getBytes());
        ByteBuffer buffer2 = ByteBuffer.wrap("12345".getBytes());
        fileChannel.write(buffer1);
        buffer2.position(1);
        buffer2.limit(3);
        fileChannel.write(buffer2,9);
        fileChannel.close();
        instance.close();
    }
}
