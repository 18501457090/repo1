package com.weibin.nio.channel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import	java.nio.channels.FileChannel;

import java.io.FileInputStream;

public class ReturnValueByChannelRead {

    private static FileInputStream in;
    private static FileChannel channel;


    public static void main(String[] args) throws IOException {
        in = new FileInputStream("D:\\Channel\\Data\\ReadData_1.txt");
        channel = in.getChannel();
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(2);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(2);
        ByteBuffer[] buffers = new ByteBuffer[]{byteBuffer1,byteBuffer2};
        long read = channel.read(buffers);
        System.out.println("A :" + read);// 取得4个字节
        byteBuffer1.clear();
        byteBuffer2.clear();
        read = channel.read(buffers);
        System.out.println("B :" + read);// 取得1个字节
        byteBuffer1.clear();
        byteBuffer2.clear();
        read = channel.read(buffers);
        System.out.println("C : " + read);// 到达流的末尾值为-1
        channel.close();
        in.close();
    }

}
