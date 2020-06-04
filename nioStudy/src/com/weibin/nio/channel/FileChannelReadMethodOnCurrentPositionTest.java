package com.weibin.nio.channel;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelReadMethodOnCurrentPositionTest {

    static FileInputStream in;
    static FileChannel channel;
    final static public void main(String[] args) throws IOException {
        in = new FileInputStream("D:\\Channel\\Data\\read\\b.txt");
        channel = in.getChannel();
        ByteBuffer allocate1 = ByteBuffer.allocate(8);
        ByteBuffer allocate2 = ByteBuffer.allocate(8);
        allocate1.position(3);
        allocate2.position(4);
        ByteBuffer[] buffers = new ByteBuffer[]{allocate1,allocate2};
        channel.read(buffers, 0, 2);
        for(int i = 0; i < buffers.length; i++){
            byte[] array = buffers[i].array();
            for (int j = 0; j < array.length; j++){
                if (array[j] == 0){
                    System.out.print(" 空格 ");
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
