package com.weibin.socket.tcp;
import java.io.IOException;
import java.net.InetSocketAddress;
import	java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ClientSocketTest_21 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.bind(new InetSocketAddress("localhost",7777));
        socket.connect(new InetSocketAddress("localhost",8088));
        socket.close();
    }

}
