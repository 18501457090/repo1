package com.weibin.nio.network.basestudy;

import java.net.NetworkInterface;
import java.net.SocketException;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/2
 **/
public class NetworkInterfacce_Test_3 {

    public static void main(String[] args) throws SocketException {
        NetworkInterface anInterface = NetworkInterface.getByName("lo");
        System.out.println("网络设备名称：" + anInterface.getName());
    }

}
