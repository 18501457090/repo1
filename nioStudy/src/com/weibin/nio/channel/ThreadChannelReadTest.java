package com.weibin.nio.channel;
import	java.util.Arrays;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ThreadChannelReadTest {

    private static FileInputStream in;
    private static FileChannel channel;

    public static void main(String[] args) throws FileNotFoundException {
        in = new FileInputStream("D:\\Channel\\Data\\ReadData.txt");
        channel = in.getChannel();
        for (int i = 0; i < 1; i++) {
            new Thread(()->{
                ByteBuffer buffer = ByteBuffer.allocate(6);
                try {
                    int read = channel.read(buffer);
                    while (read != -1){
                        byte[] array = buffer.array();
                        System.out.println("Thread 1 : " + new String(array,0,read));
                        buffer.clear();
                        read = channel.read(buffer);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(()->{
                ByteBuffer buffer = ByteBuffer.allocate(6);
                try {
                    int read = channel.read(buffer);
                    while (read != -1){
                        byte[] array = buffer.array();
                        System.out.println("Thread 2 : " +new String(array,0,read));
                        buffer.clear();
                        read = channel.read(buffer);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }


}
