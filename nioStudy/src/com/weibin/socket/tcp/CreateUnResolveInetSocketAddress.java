package com.weibin.socket.tcp;

import java.net.InetSocketAddress;
import java.util.UUID;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/5
 **/
public class CreateUnResolveInetSocketAddress {

    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("www.baidu.com",80);
        // 输出false的原因是可以对www.baidu.com进行解析
        System.out.println(socketAddress.isUnresolved());
        InetSocketAddress socketAddress2 = new InetSocketAddress("www.baidu.360.com",80);
        // 输出false的原因是不能对该域名进行解析
        System.out.println(socketAddress2.isUnresolved());
        // 输出true的原因是因为即使能对www.baidu.com进行解析,内部也不解析
        InetSocketAddress unresolved = InetSocketAddress.createUnresolved("www.baidu.com", 80);
        System.out.println(unresolved.isUnresolved());
        // 输出true的原因是内部从来不解析
        InetSocketAddress unresolved1 = InetSocketAddress.createUnresolved("www.baidu.360.com", 80);
        System.out.println(unresolved1.isUnresolved());


    }

}
