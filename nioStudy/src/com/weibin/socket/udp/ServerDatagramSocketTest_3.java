package com.weibin.socket.udp;
import java.io.IOException;
import	java.net.DatagramPacket;
import	java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/9
 **/
public class ServerDatagramSocketTest_3 {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8088);
        byte[] bytes = new byte[10];
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
        socket.receive(packet);
        byte[] data = packet.getData();
        System.out.println(new String(data,0,data.length));
        socket.close();
    }

}
