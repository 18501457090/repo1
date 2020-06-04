package com.weibin.nio.nio.selector;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/13
 **/
public class ClientSocketChannelTest_11 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8088);
        socket.getOutputStream().write("1234567".getBytes());
        socket.close();

    }


}
