package com.weibin.socket.tcp;

import java.io.IOException;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class ClientSocketTest_16 {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 100; i++){
            Socket socket = new Socket("localhost",8088);
            System.out.println("客户端发起请求连接数 ： " + (i + 1));
        }
    }

}
