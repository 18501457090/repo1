package com.weibin.nio.channel;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelWriteOnRemainingTest {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Channel\\Data\\write\\WriteTest_2.txt");
        FileOutputStream inputStream = new FileOutputStream(file);
        FileChannel channel = inputStream.getChannel();
        channel.write(ByteBuffer.wrap("123456".getBytes()));
        channel.position(3);
        ByteBuffer buffer1 = ByteBuffer.wrap("abcde1".getBytes());
        ByteBuffer buffer2 = ByteBuffer.wrap("uvwxyz2".getBytes());
        ByteBuffer[] buffers = new ByteBuffer[]{buffer1,buffer2};
        buffer1.position(1);
        buffer1.limit(3);
        buffer2.position(2);
        buffer2.limit(4);
        channel.write(buffers);
        channel.close();
        inputStream.close();


    }

}
