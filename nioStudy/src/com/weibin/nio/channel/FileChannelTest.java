package com.weibin.nio.channel;
import	java.nio.ByteBuffer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class FileChannelTest {

    public static void main(String[] args) throws FileNotFoundException {
        try (FileOutputStream out = new FileOutputStream("D:\\TestData.txt");
             FileChannel channel = out.getChannel();){
            ByteBuffer buffer = ByteBuffer.wrap("abcdefghijk".getBytes());
            System.out.println("A position : " + buffer.position());
            System.out.println("B channel.write()返回值为：" + channel.write(buffer));
            System.out.println("C position : " + channel.position());
            //channel.position(3);
            // 在当前位置再次写入
            //int write = channel.write(buffer);
            ByteBuffer buffer1 = ByteBuffer.wrap("opqrest".getBytes());
            buffer1.limit(2);
            System.out.println("D channel.write()返回值为 : " + channel.write(buffer1));
            System.out.println("E position : " + channel.position());
        }catch (Exception e){
            e.printStackTrace();
        }



    }

}
