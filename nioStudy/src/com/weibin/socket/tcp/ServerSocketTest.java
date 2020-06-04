package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/2
 **/
public class ServerSocketTest {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8088);
        System.out.println("服务端Socket阻塞开始：" + new Date().toLocaleString());
        Socket accept = socket.accept();
        System.out.println("收到客户端的连接请求：" + accept.getInetAddress() + " : " + accept.getPort());
        System.out.println("服务端Socket阻塞结束：" + new Date().toLocaleString());
        socket.close();
    }

}
