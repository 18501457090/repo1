package com.weibin.nio.channel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

// 验证通道的部分批量写入具有同步特性
public class FileChannelBatchWriteSyncTest {

    static FileOutputStream out;
    static FileChannel channel;
    static int count = 0;

    public static void main(String[] args) throws IOException, InterruptedException {
        out = new FileOutputStream("D:\\Channel\\Data\\write\\WriteTest_6.txt");
        channel = out.getChannel();
        channel.position(1);
        for (int i = 0; i < 10; i++){
            new Thread(()->{
                ByteBuffer[] byteBufferArray = getByteBufferArray("aaaa", "bbbb");
                try {
                    channel.write(byteBufferArray,0,2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(()->{
                ByteBuffer[] byteBufferArray = getByteBufferArray("xxxx", "yyyy");
                try {
                    channel.write(byteBufferArray,0,2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(3000);
        channel.close();
        out.close();

    }

    synchronized public static ByteBuffer[] getByteBufferArray(String printString,String printString2){
        ++count;
        ByteBuffer wrap1 = ByteBuffer.wrap((printString + count + "\r\n").getBytes());
        ByteBuffer wrap2 = ByteBuffer.wrap((printString2 + count + "\r\n").getBytes());
        ByteBuffer[] returnArray = {wrap1,wrap2};
        return returnArray;
    }

}
