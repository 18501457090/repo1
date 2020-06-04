package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.*;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ServerSocketInetAddressTest {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8088);
        Socket accept = socket.accept();
        InetSocketAddress socketAddress = (InetSocketAddress) socket.getLocalSocketAddress();
        InetAddress address = socketAddress.getAddress();
        byte[] address1 = address.getAddress();
        System.out.print("服务端IP地址为：");
        for (int i = 0 ;i < address1.length; i++){
            System.out.print(address1[i] + " ");
        }
        System.out.println();
        System.out.println("服务端的端口号： " + socketAddress.getPort());
        accept.close();
        socket.close();

    }

}
