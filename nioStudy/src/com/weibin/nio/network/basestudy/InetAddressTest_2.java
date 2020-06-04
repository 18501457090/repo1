package com.weibin.nio.network.basestudy;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/1
 **/
public class InetAddressTest_2 {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.print("地址为：");
        byte[] address = localHost.getAddress();
        for (byte b : address){
            System.out.print(b + " ");
        }
        System.out.println();
        System.out.println(localHost.getClass().getName());
        System.out.println();
        System.out.print("回环/回调地址为：");
        InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
        byte[] addressAddress = loopbackAddress.getAddress();
        for (byte b : addressAddress){
            System.out.print(b + " ");
        }
        System.out.println();

    }

}
