package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/7
 **/
public class SeverSocketKeepAliveTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket socket = new ServerSocket(8088);
        Socket accept = socket.accept();
        Thread.sleep(Integer.MAX_VALUE);
        accept.close();
        socket.close();
    }

}
