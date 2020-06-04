package com.weibin.socket.tcp;
import	java.util.Date;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ServerSocketTest_13 {

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket socket = new ServerSocket(8088);
            int soTimeout = socket.getSoTimeout();
            System.out.println("默认超时时间为：" + soTimeout);
            socket.setSoTimeout(4000);
            System.out.println("开始阻塞：" + new Date().toLocaleString());
            socket.accept();
            System.out.println("结束阻塞：" + new Date().toLocaleString());
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
