package com.weibin.socket.tcp;
import	java.io.ObjectOutputStream;
import	java.io.ObjectInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/4
 **/
public class ServerSocketTest_8 {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8088);
        Socket clientSocket = socket.accept();
        // 输入开始
        InputStream in = clientSocket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(in);
        int byteLength = ois.readInt();
        byte[] bytes = new byte[byteLength];
        ois.readFully(bytes);
        String str = new String(bytes);
        System.out.println("第一次获取到数据：" + str);
        // 输出开始
        OutputStream out = clientSocket.getOutputStream();
        String sendData = "send Data To Client 1 " + new Date().toLocaleString() + "\r\n";
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeInt(sendData.getBytes().length);
        oos.flush();
        oos.write(sendData.getBytes());
        oos.flush();
        // 输入开始
        byteLength = ois.readInt();
        bytes = new byte[byteLength];
        ois.readFully(bytes);
        str = new String(bytes);
        System.out.println("第二次获取到数据：" + str);
        in.close();
        clientSocket.close();
        socket.close();




    }

}
