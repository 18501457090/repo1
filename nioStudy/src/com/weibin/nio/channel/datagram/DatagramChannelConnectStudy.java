package com.weibin.nio.channel.datagram;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/24
 **/
public class DatagramChannelConnectStudy {

    public static void main(String[] args) throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        SocketAddress addr = new InetSocketAddress("localhost",8088);
        // 如果安装了安全管理器，之后再调用send()/receive()方法就不会进行安全检查了。
        // 任何发往该SocketAddress对象所描述的目的地址和端口之外的数据报都会导致抛出异常。
        datagramChannel.connect(addr);
        boolean connected = datagramChannel.isConnected();
        System.out.println("connected : " + connected);
    }

}
