package com.weibin.nio.channel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import	java.nio.channels.FileChannel;

import java.io.FileInputStream;

public class FileChannelReadOnBufferCurrentPositionTest {

    static FileInputStream in;
    static FileChannel channel;

    public static void main(String[] args) throws IOException {
        in = new FileInputStream("D:\\Channel\\Data\\ReadData_1.txt");
        channel = in.getChannel();
        channel.position(2);
        ByteBuffer allocate1 = ByteBuffer.allocate(2);
        ByteBuffer allocate2 = ByteBuffer.allocate(2);
        allocate1.position(1);
        ByteBuffer[] buffers = new ByteBuffer[]{allocate1,allocate2};
        channel.read(buffers);
        for (int i = 0; i < buffers.length; i++){
            byte[] array = buffers[i].array();
            for (int j = 0; j < array.length; j++){
                if (array[j] == 0){
                    System.out.print("空格 ");
                } else {
                    System.out.print((char) array[j]);
                }
            }
            System.out.println();
        }
        channel.close();
        in.close();
    }

}
