package com.weibin.aio.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/18
 **/
public class AsynchronousSocketChannelTest_2 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8088);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("send data to server,i'm from client2".getBytes());
        outputStream.flush();
        socket.close();
    }

}
