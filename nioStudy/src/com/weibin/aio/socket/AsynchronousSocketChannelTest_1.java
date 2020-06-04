package com.weibin.aio.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/18A
 **/
public class AsynchronousSocketChannelTest_1 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8088);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("send data to server,i'm from client1".getBytes());
        outputStream.flush();
        socket.close();
    }

}
