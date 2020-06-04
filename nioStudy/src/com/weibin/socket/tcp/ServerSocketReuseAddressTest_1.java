package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ServerSocketReuseAddressTest_1 {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket socket = new ServerSocket();
        socket.setReuseAddress(false); // 即不允许端口复用
        socket.bind(new InetSocketAddress("localhost",8088),90);
        Socket accept = socket.accept();
        Thread.sleep(1000);
        accept.close();
        socket.close();
    }

}
