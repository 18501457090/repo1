package com.weibin.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/7
 **/
public class ServerSocketTimeOutTest_1 {

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket socket = new ServerSocket(8088);
            Socket accept = socket.accept();
            System.out.println("默认超时时间,0即禁用：" + accept.getSoTimeout());
            accept.setSoTimeout(5000);
            InputStream in = accept.getInputStream();
            byte[] bytes = new byte[1024];
            System.out.println("begin : " + System.currentTimeMillis());
            int readLength = in.read(bytes);
            System.out.println("end : " + System.currentTimeMillis());
        } catch (Exception e){
            System.out.println("time out : " + System.currentTimeMillis());
            e.printStackTrace();
        }


    }

}
