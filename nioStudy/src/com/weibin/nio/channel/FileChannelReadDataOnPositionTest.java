package com.weibin.nio.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/28
 **/
public class FileChannelReadDataOnPositionTest {

    private static FileInputStream in;
    private static FileChannel channel;

    public static void main(String[] args) throws IOException {
        in = new FileInputStream("D:\\Channel\\Data\\read\\a.txt");
        channel = in.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(5);
        buffer.position(3);// 从缓冲区的第三个字节序列处开始放入字节
        channel.read(buffer,2);//从通道的第二个字节序列处开始读取
        byte[] array = buffer.array();
        for (byte b : array){
            if (b == 0){
                System.out.print(" 空格 ");
            } else {
                System.out.print((char)b);
            }
        }
        channel.close();
        in.close();
    }

}
