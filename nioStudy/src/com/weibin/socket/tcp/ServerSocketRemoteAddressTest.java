package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.*;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ServerSocketRemoteAddressTest {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8088);
        Socket accept = socket.accept();
        InetAddress address = accept.getInetAddress();
        InetSocketAddress socketAddress = (InetSocketAddress) accept.getRemoteSocketAddress();
        byte[] bytes = address.getAddress();
        System.out.print("客户端的IP地址为：");
        for (int i = 0; i < bytes.length; i++){
            System.out.print(bytes[i] + " ");
        }
        System.out.println();
        System.out.println("客户端的端口号为：" + socketAddress.getPort());
        accept.close();
        socket.close();

    }


}
