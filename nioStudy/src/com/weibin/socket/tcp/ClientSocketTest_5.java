package com.weibin.socket.tcp;
import	java.util.Date;
import java.io.*;

import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/4
 **/
public class ClientSocketTest_5 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost",8088);
        OutputStream stream1 = socket.getOutputStream();
        stream1.write(("测试连通性,当前时间为：" + new Date().toLocaleString()).getBytes());
        InputStream stream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line;
        while ((line  = reader.readLine()) != null){
            System.out.println("客户端收到服务端回送数据 ： " + line);
        }
        reader.close();
        stream.close();
        stream1.close();
        socket.close();
    }

}
