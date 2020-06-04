package com.weibin.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/6
 **/
public class ServerSocketLingerTest_1 {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8088);
        Socket accept = socket.accept();
        System.out.println("A 默认逗留时间：" + accept.getSoLinger());
        accept.setSoLinger(true,0);// 立即返回，丢弃发送缓冲区中的数据
        System.out.println("B 修改后的逗留时间：" + accept.getSoLinger());
        OutputStream out = accept.getOutputStream();
        for (int i = 0; i < 10; i++){
            out.write(("12345678912345678912345678912345678912" +
                    "3456789123456789123456789123456789").getBytes());
        }
        out.write("end!".getBytes());
        System.out.println("socket close before : " + System.currentTimeMillis());
        out.close();
        accept.close();
        System.out.println("socket close after : " + System.currentTimeMillis());
        socket.close();

    }
}
