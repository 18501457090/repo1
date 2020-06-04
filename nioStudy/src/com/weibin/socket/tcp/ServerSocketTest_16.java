package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ServerSocketTest_16 {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket socket = new ServerSocket(8088);
        Thread.sleep(5000);
        for (int i = 1; i < 100; i++){
            System.out.println(" accept begin For " + i);
            socket.accept();
            System.out.println(" accept end For " + i);
        }
        socket.close();
    }

}
