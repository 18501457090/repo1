package com.weibin.nio.channel;
import java.io.IOException;
import	java.nio.ByteBuffer;
import java.io.File;
import java.io.FileNotFoundException;
import	java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class FileChannelWriteOnCurrentPositionTest {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("D:\\Channel\\Data\\write\\WriteTest_4.txt"));
        FileChannel channel = fos.getChannel();
        ByteBuffer buffer1 = ByteBuffer.wrap("abcde".getBytes());
        ByteBuffer buffer2 = ByteBuffer.wrap("12345".getBytes());
        ByteBuffer[] buffers = new ByteBuffer[]{buffer1,buffer2};
        channel.write(ByteBuffer.wrap("qqqqq".getBytes()));
        channel.position(2);
        // 此处的offset指的是从buffers中第几个数组写到第length个数组的数据
        channel.write(buffers,1,1);
        channel.close();
        fos.close();


    }

}
