package com.weibin.socket.udp;
import java.io.IOException;
import	java.net.DatagramPacket;
import	java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.channels.spi.AbstractInterruptibleChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/9
 **/
public class ClientDatagramSocketTest_3 {

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket();
        socket.connect(new InetSocketAddress("localhost",8088));
        byte[] bytes = "1234567890".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
        socket.send(packet);
        socket.close();
    }

}
