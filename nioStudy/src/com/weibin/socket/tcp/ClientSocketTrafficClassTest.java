package com.weibin.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/7
 **/
public class ClientSocketTrafficClassTest {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        /*int aClass = socket.getTrafficClass();
        System.out.println("默认的服务质量为：" + aClass);*/
        socket.setTrafficClass(0x3);
        socket.connect(new InetSocketAddress("localhost",8088));
        OutputStream out = socket.getOutputStream();
        out.write("send TestData!".getBytes());
        out.close();
        socket.close();
    }

}
