package com.review.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/20
 **/
public class ChannelCopy {

    public static void main(String[] args) throws IOException {
        ReadableByteChannel source = Channels.newChannel(System.in);
        WritableByteChannel dest = Channels.newChannel(System.out);
        channelCopy1(source,dest);
        //channelCopy2(source,dest);
        source.close();
        dest.close();
    }

    private static void channelCopy1(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(16 * 1024);
        while (src.read(byteBuffer) != -1){
            System.out.println("---copy1 start ---" + byteBuffer.position());
            byteBuffer.flip();
            System.out.println("---copy1 flip ---" + byteBuffer.position());

            dest.write(byteBuffer);
            byteBuffer.clear();
            /*for (int i = 0 ; i < byteBuffer.limit(); i ++){
                System.out.print(byteBuffer.get());
            }*/
        }
        System.out.println("---copy1 end ---" + byteBuffer.position());
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()){
            dest.write(byteBuffer);
        }
    }

    private static void channelCopy2(ReadableByteChannel src,WritableByteChannel dest) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(16 * 1024);
        while (src.read(byteBuffer) != -1){
            System.out.println("---copy2 start ---" + byteBuffer.position());
            byteBuffer.flip();
            System.out.println("---copy2 flip ---" + byteBuffer.position());
            while (byteBuffer.hasRemaining()){
               dest.write(byteBuffer);
           }
            System.out.println("---copy2 end ---" + byteBuffer.position());
            byteBuffer.clear();
            System.out.println("---copy2 clear ---" + byteBuffer.position());

        }
    }

}
