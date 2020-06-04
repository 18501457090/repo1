package com.weibin.nio.channel;
import java.io.*;
import	java.util.Date;
import java.nio.ByteBuffer;
import	java.util.concurrent.CountDownLatch;

import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/28
 **/
public class FileChannelReadWriteSyncTest {

    static FileOutputStream out;
    static FileChannel channel;
    static RandomAccessFile in;
    static ByteBuffer buffer = ByteBuffer.allocate( (int)(1024 * 1024 * 1024 * 1.3));

    public static void main(String[] args) throws IOException,Exception {
        in = new RandomAccessFile("E:\\WriteDataTest_1.txt","rw");
        channel = in.getChannel();
        CountDownLatch latch = new CountDownLatch(2);
        new Thread(()->{
            try {
                channel.read(buffer);
                System.out.println(Thread.currentThread().getName() + " EndTime : " + new Date().toLocaleString());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }).start();
        new Thread(()->{
            try {
                channel.write(ByteBuffer.wrap("1111111111111".getBytes()),channel.size() + 1);
                System.out.println(Thread.currentThread().getName() + " EndTime : " + new Date().toLocaleString());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }).start();
        System.out.println("StartTime : " + new Date().toLocaleString());
        latch.await();
        channel.close();
        in.close();
        //testWriteData();

    }


    static void testWriteData() throws Exception{
        CountDownLatch latch = new CountDownLatch(2);
        out = new FileOutputStream("D:\\Channel\\Data\\write\\WriteDataTest_1.txt");
        channel = out.getChannel();
        System.out.println("StartTime : " + new Date().toLocaleString());
        new Thread(()->{
            try {
                for (int i = 0 ;i < 1000000000;i++){
                    channel.write(ByteBuffer.wrap((Thread.currentThread().getName() + "  ----> "
                            + Math.random() + "\r\n").getBytes()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }).start();
        new Thread(()->{
            try {
                for (int i = 0 ;i < 1000000000;i++){
                    channel.write(ByteBuffer.wrap((Thread.currentThread().getName() + "  ----> "
                            + Math.random() + "\r\n").getBytes()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }).start();
        latch.await();
        System.out.println("EndTime : " + new Date().toLocaleString());
        channel.close();
        out.close();
    }


}
