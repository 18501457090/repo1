package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ClientSocketTest_17 {

    public static void main(String[] args) throws IOException {
        InetAddress localHost = InetAddress.getLocalHost();
        for (int i = 1; i < 101; i ++){
            Socket socket = new Socket(localHost,8088);
            System.out.println("客户端发起第 " + i + " 次请求！");
        }
    }

}
