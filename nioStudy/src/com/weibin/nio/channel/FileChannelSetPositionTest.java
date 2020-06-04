package com.weibin.nio.channel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import	java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Desc: 设置位置与获得大小
 * @author: zwb
 * @Date: 2019/12/28
 **/
public class FileChannelSetPositionTest {

    public static void main(String[] args) throws IOException {
        ByteBuffer buffer1 = ByteBuffer.wrap("abcd".getBytes());
        ByteBuffer buffer2 = ByteBuffer.wrap("fde".getBytes());
        FileOutputStream out = new FileOutputStream("D:\\Channel\\Data\\write\\WriteData_Test_1.txt");
        FileChannel channel = out.getChannel();
        System.out.println("A position : " + channel.position() + " size : " + channel.size());
        channel.write(buffer1);
        System.out.println("B position : " + channel.position() + " size : " + channel.size());
        channel.position(2);
        System.out.println("C position : " + channel.position() + " size : " + channel.size());
        channel.write(buffer2);
        System.out.println("D position : " + channel.position() + " size : " + channel.size());
        channel.close();
        //out.flush();
        out.close();


    }

}
