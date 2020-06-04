package com.weibin.nio.channel;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelReadTest {

    private static FileInputStream in;
    private static FileChannel channel;

    public static void main(String[] args) throws IOException {
         in = new FileInputStream("D:\\Channel\\Data\\ReadData.txt");
         channel = in.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(30);
        int read = channel.read(buffer);
        System.out.println("one readLength : " + read);
        byte[] array = buffer.array();
        String str = new String(array,"UTF-8");
        System.out.println(str);
        read = channel.read(buffer);
        System.out.println("第二次读取字节数：" + read);
        buffer.clear();
        read = channel.read(buffer);
        System.out.println("清空缓冲区之后再次读取到的字节数： " + read);
        byte[] array1 = buffer.array();
        String str1 = new String(array1,"UTF-8");
        System.out.println(str1);
        channel.close();
        in.close();

    }



}
