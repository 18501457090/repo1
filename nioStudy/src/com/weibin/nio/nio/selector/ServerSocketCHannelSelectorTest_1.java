package com.weibin.nio.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/12
 **/
public class ServerSocketCHannelSelectorTest_1 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost",8888));
        socket.close();
        Socket socket1 = new Socket();
        socket1.connect(new InetSocketAddress("localhost",9999));
        socket1.close();
    }

}
