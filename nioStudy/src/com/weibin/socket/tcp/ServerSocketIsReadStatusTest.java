package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ServerSocketIsReadStatusTest {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8088);
        Socket accept = socket.accept();
        System.out.println("A isInputShutdown : " + accept.isInputShutdown());
        accept.shutdownInput();
        System.out.println("B isInputShutdown : " + accept.isInputShutdown());
        accept.close();
        socket.close();


    }

}
