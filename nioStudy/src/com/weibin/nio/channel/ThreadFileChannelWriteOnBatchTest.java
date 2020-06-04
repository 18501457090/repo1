package com.weibin.nio.channel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ThreadFileChannelWriteOnBatchTest {

    private static FileOutputStream out;
    private static FileChannel channel;

    public static void main(String[] args) throws IOException, InterruptedException {
        /*File file = new File("D:\\Channel\\Data\\write\\WriteTest_3.txt");
        out = new FileOutputStream(file);*/
        out = new FileOutputStream("D:\\Channel\\Data\\write\\WriteTest_3.txt");
        channel = out.getChannel();
        for (int i = 0 ;i < 10; i++){
            new Thread(()->{
                final ByteBuffer wrap = ByteBuffer.wrap((Thread.currentThread().getName() + "\t oooo1\r\n").getBytes());
                ByteBuffer wrap1 = ByteBuffer.wrap((Thread.currentThread().getName() + "\t oooo2\r\n").getBytes());
                ByteBuffer[] buffers = new ByteBuffer[]{wrap,wrap1};
                try {
                    channel.write(buffers);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(()->{
                final ByteBuffer wrap = ByteBuffer.wrap((Thread.currentThread().getName() + "\t qqqqq\r\n").getBytes());
                ByteBuffer wrap1 = ByteBuffer.wrap((Thread.currentThread().getName() + "\t yyyyy\r\n").getBytes());
                ByteBuffer[] buffers = new ByteBuffer[]{wrap,wrap1};
                try {
                    channel.write(buffers);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(3000);
        channel.close();
        out.close();

    }




}
