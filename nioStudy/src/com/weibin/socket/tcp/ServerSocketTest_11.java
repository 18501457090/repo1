package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/4
 **/
public class ServerSocketTest_11 {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket socket = new ServerSocket(8088);
        Thread.sleep(Integer.MAX_VALUE);

    }

}
