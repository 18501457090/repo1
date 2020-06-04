package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ClientSocketStatusTest {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        System.out.println("isBound ? " + socket.isBound());
        socket.bind(new InetSocketAddress("localhost",7777));
        System.out.println("isBound ? " + socket.isBound());
        System.out.println("isConnected ? " +socket.isConnected());
        socket.connect(new InetSocketAddress("localhost",8088),1000);
        System.out.println("isConnected ? " + socket.isConnected());
        System.out.println("isClosed() ? "  + socket.isClosed());
        socket.close();
        System.out.println("isClosed() ? " + socket.isClosed());
    }


}
