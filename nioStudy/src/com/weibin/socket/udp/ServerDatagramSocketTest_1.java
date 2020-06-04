package com.weibin.socket.udp;
import java.io.IOException;
import java.net.*;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/8
 **/
public class ServerDatagramSocketTest_1 {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8088);
        byte[] bytes = new byte[12];
        //构造方法的第二个参数也要写上10,代表要接受数据的长度为10
        DatagramPacket packet = new DatagramPacket(bytes,10);
        socket.receive(packet);
        socket.close();
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        SocketAddress socketAddress = packet.getSocketAddress();
        System.out.println("address : " + address + "  port ： " + port +  " socketAddress : " + socketAddress);
        System.out.println("包中数据的长度：" + packet.getLength());
        System.out.println("包中的内容：" + new String(packet.getData(),0,packet.getLength()));

    }

}
