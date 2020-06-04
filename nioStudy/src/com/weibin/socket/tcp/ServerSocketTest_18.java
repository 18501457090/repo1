package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ServerSocketTest_18 {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket socket = new ServerSocket();
        socket.bind(new InetSocketAddress(8088),10000);
        Thread.sleep(Integer.MAX_VALUE);
        socket.accept();
    }

}
