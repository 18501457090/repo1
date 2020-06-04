package com.weibin.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/6
 **/
public class ClientSocketSendBufferSizeTest {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        System.out.println("A sendBufferSize : " + socket.getSendBufferSize());
        socket.setSendBufferSize(1024);
        System.out.println("B sendBufferSize : " + socket.getSendBufferSize());
        socket.connect(new InetSocketAddress("localhost",8088));
        OutputStream out = socket.getOutputStream();
        for (int i = 0; i < 500000; i++){
            out.write("123456789123456789123456789123456789123456789123456789123456789".getBytes());
            System.out.println("count : " + (i + 1));
        }
        out.close();
        socket.close();
    }

}
