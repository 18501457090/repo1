package com.weibin.nio.network.basestudy;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/2
 **/
public class NetworkInterface_Test_2 {

    public static void main(String[] args) throws SocketException {
        NetworkInterface anInterface = NetworkInterface.getByIndex(1);
        System.out.println("网络设备名称：" + anInterface.getName());
        System.out.println("网络设备显示名称：" + anInterface.getDisplayName());
        System.out.println("IP地址：" + Arrays.toString(anInterface.getInterfaceAddresses().toArray()));
    }

}
