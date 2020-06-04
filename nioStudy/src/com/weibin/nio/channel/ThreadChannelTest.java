package com.weibin.nio.channel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ThreadChannelTest {

    private static FileOutputStream out;
    private static FileChannel channel;


    public static void main(String[] args) throws IOException, InterruptedException {
        out = new FileOutputStream("D:\\SyncTestData.txt");
        channel = out.getChannel();
        for (int i =0;i < 10; i++){
            new Thread(()-> {
                try {
                    channel.write(ByteBuffer.wrap("abcde\r\n".getBytes()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(()->{
                try {
                    channel.write(ByteBuffer.wrap("我是中国人\r\n" .getBytes()));
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
