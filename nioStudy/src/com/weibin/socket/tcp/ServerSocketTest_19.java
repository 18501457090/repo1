package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ServerSocketTest_19 {

    public static void main(String[] args) throws IOException {
        ServerSocket  socket = new ServerSocket();
        System.out.println("无参构造的端口为：" + socket.getLocalPort());
        socket.bind(new InetSocketAddress(8088),20);
        System.out.println("bind()方法执行完毕后的端口地址为：" + socket.getLocalPort());
        InetSocketAddress socketAddress = (InetSocketAddress) socket.getLocalSocketAddress();
        System.out.println("HostName : " + socketAddress.getHostName());
        System.out.println("HostString : " + socketAddress.getHostString());
        System.out.println("Address : " + socketAddress.getAddress());
    }


}
