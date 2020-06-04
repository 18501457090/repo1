package com.weibin.nio.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/28
 **/
public class FileChannelReadAppointDataTest {

    static FileInputStream out;
    static FileChannel channel;

    public static void main(String[] args) throws IOException {
        out = new FileInputStream("D:\\Channel\\Data\\read\\a.txt");
        channel = out.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(2);
        int read = channel.read(buffer, 2); // 读取两个字节
        System.out.println("A readLength : " + read);
        buffer.clear();
        read = channel.read(buffer,10); // 到达流的末尾值为-1
        System.out.println("B readLength : " + read);
        buffer.clear();
        channel.close();
        out.close();
    }


}
