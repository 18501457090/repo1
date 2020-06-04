package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ServerSocketTest_15 {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket socket = new ServerSocket(8088,1);
        Thread.sleep(10000);
        System.out.println("accept1 Begin!");
        Socket accept1 = socket.accept();
        System.out.println("accept1 End!");
        System.out.println("------------------------");
        System.out.println("accept2 Begin!");
        Socket accept2 = socket.accept();
        System.out.println("accept2 End!");
        System.out.println("------------------------");
        System.out.println("accept3 Begin!");
        Socket accept3 = socket.accept();
        System.out.println("accept3 End!");
        accept1.close();
        accept2.close();
        accept3.close();
        socket.close();
    }

}
