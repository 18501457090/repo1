package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ServerSocketTest_20 {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket();
        InetAddress address = InetAddress.getByName("localhost");
        InetSocketAddress socketAddress = new InetSocketAddress(address,8088);
        socket.bind(socketAddress);
        Socket accept = socket.accept();
        accept.close();
        socket.close();
    }

}
