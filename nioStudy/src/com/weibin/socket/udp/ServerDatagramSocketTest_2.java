package com.weibin.socket.udp;
import java.io.IOException;
import	java.net.DatagramPacket;
import	java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/8
 **/
public class ServerDatagramSocketTest_2 {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8088);
        byte[] bytes = new byte[10];
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
        socket.receive(packet);
        socket.close();
        bytes = packet.getData();
        System.out.println(new String(bytes,0,packet.getLength()));
    }
}
