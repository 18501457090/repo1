package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ServerSocketIsWriteTest {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8088);
        Socket accept = socket.accept();
        System.out.println("A isOutputShutdown : " + accept.isOutputShutdown());
        accept.shutdownOutput();
        System.out.println("A isOutputShutdown : " + accept.isOutputShutdown());
        accept.close();
        socket.close();
    }

}
