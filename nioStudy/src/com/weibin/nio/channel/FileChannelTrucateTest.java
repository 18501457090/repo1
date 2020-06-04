package com.weibin.nio.channel;
import java.io.IOException;
import	java.nio.ByteBuffer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @Desc: 截断缓冲区
 * @author: zwb
 * @Date: 2019/12/28
 **/
public class FileChannelTrucateTest {

    public static void main(String[] args) throws IOException {
        FileOutputStream out = new FileOutputStream("D:\\Channel\\Data\\write\\WriteData_Test_2.txt");
        ByteBuffer buffer = ByteBuffer.wrap("12345678".getBytes());
        FileChannel channel = out.getChannel();
        channel.write(buffer);
        System.out.println("A size : " + channel.size() + " position: " + channel.position());
        channel.truncate(3000);
        System.out.println("B size : " + channel.size() + " position : " + channel.position());
        channel.close();
        out.flush();
        out.close();
    }

}
