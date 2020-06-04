package com.weibin.nio.pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Random;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/25
 **/
public class PipeTest2 {

    public static void main(String[] args) throws IOException {
        // 创建一个写通道
        WritableByteChannel out = Channels.newChannel(System.out);
        // 获取管道对应的读通道
        ReadableByteChannel channel = startWork(10);
        ByteBuffer buffer = ByteBuffer.allocate(100);
        while (channel.read(buffer) >= 0){
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
    }

    static ReadableByteChannel startWork(int reps) throws IOException {
        Pipe pipe = Pipe.open();
        Worker worker = new Worker(pipe.sink(),reps);
        worker.start();
        return pipe.source();
    }

    static class Worker extends Thread {
        WritableByteChannel channel;
        int reps;
        Worker(WritableByteChannel channel,int rep){
            this.channel = channel;
            this.reps = rep;
        }

        @Override
        public void run() {
            ByteBuffer buf = ByteBuffer.allocate(100);
            try {
                for (int i = 0; i < this.reps; ++i){
                    doSomeWork(buf);
                    //System.out.println("limit : " + buf.limit());
                    while (channel.write(buf) > 0){

                    }
                }
                this.channel.close();
            } catch (Exception e){
                e.printStackTrace();
            }

        }
        String[] products = {
                "No good deed goes unpunished",
                "To be, or what?",
                "No matter where you go, there you are",
                "Just say \"Yo\"",
                "My karma ran over my dogma"};

        Random rnd = new Random();
        void doSomeWork(ByteBuffer buffer){
            int anInt = rnd.nextInt(products.length);
            buffer.clear();
            buffer.put(products[anInt].getBytes());
            buffer.put("\r\n".getBytes());
            buffer.flip();
        }

    }

}
