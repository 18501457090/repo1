package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/7
 **/
public class ClientSocketKeepAliveTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost",8088);
        int soLinger = socket.getSoLinger();
        System.out.println("linger : "  + soLinger);
        socket.setKeepAlive(true);
        Thread.sleep(Integer.MAX_VALUE);
        socket.close();
    }


}
