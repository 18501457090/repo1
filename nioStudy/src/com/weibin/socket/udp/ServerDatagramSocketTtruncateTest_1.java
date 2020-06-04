package com.weibin.socket.udp;
import java.nio.ByteBuffer;
import	java.nio.file.StandardOpenOption;
import java.io.File;
import	java.nio.channels.FileChannel;
import java.io.IOException;
import	java.net.DatagramPacket;
import	java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/8
 **/
public class ServerDatagramSocketTtruncateTest_1 {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8088);
        byte[] bytes = new byte[65507];
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length);
        socket.receive(packet);
        socket.close();
        System.out.println("服务端接受到的数据长度为：" + packet.getLength());
        File file = new File("D:\\Channel\\Data\\write\\DatagramSocketWrite.txt");
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.CREATE_NEW,StandardOpenOption.WRITE);
        ByteBuffer buffer = ByteBuffer.wrap(packet.getData());
        channel.write(buffer);
        channel.close();
    }

}
