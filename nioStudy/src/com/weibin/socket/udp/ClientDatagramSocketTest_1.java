package com.weibin.socket.udp;
import java.io.IOException;
import	java.net.DatagramPacket;
import	java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/8
 **/
public class ClientDatagramSocketTest_1 {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        socket.connect(new InetSocketAddress("localhost",8088));
        String str = "1234567890";
        byte[] bytes = str.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
        socket.send(packet);
        socket.close();

    }

}
