package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ServerSocketPortTest {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8088);
        Socket accept = socket.accept();
        System.out.println("服务端的端口号为：" + socket.getLocalPort());
        System.out.println("客户端的端口号为：" + accept.getPort());
        accept.close();
        socket.close();

    }

}
