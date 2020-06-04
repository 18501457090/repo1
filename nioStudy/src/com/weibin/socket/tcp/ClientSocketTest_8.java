package com.weibin.socket.tcp;
import	java.io.ObjectInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/4
 **/
public class ClientSocketTest_8 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8088);
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        // 输出开始
        String sendData = "send Data To Server 1 " + new Date().toLocaleString() + "\r\n";
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeInt(sendData.getBytes().length);
        oos.flush();
        oos.write(sendData.getBytes());
        oos.flush();
        // 输入开始
        ObjectInputStream ois = new ObjectInputStream(in);
        int anInt = ois.readInt();
        byte[] bytes = new byte[anInt];
        ois.readFully(bytes);
        String str = new String(bytes);
        System.out.println("Data : " + str);
        // 输出开始
        sendData = "send Data To Server 2 " + new Date().toLocaleString() + "\r\n";
        oos.writeInt(sendData.getBytes().length);
        oos.flush();
        oos.write(sendData.getBytes());
        oos.flush();
        oos.close();
        ois.close();
        socket.close();


    }



}
