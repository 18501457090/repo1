package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/7
 **/
public class ServerSocketTrafficClassTest {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8088);
        Socket accept = socket.accept();
        int trafficClass = accept.getTrafficClass();
        System.out.println("trafficClass : " + trafficClass);
        accept.close();
        socket.close();
    }

}
