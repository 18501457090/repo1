package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class SocketTimeOutTest {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.bind(new InetSocketAddress("192.168.1.8",8088));
        socket.connect(new InetSocketAddress("www.baidu.com",8888),3000);
        socket.close();
    }


}
