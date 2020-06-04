package com.weibin.nio.network.basestudy;

import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/1
 **/
public class InterfaceAddressTest_1 {

    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()){
            NetworkInterface element = interfaces.nextElement();
            System.out.println("获取网络设备名称：" + element.getName());
            System.out.println("获取网络设备显示名称：" + element.getDisplayName());
            List<InterfaceAddress> addresses = element.getInterfaceAddresses();
            for (InterfaceAddress address : addresses){
                if (address.getAddress() != null){
                    String hostAddress = address.getAddress().getHostAddress();
                    System.out.println("HostAddress : " + hostAddress);
                }
                if (address.getBroadcast() != null){
                    System.out.println("Broadcast.hostAddress() : " + address.getBroadcast().getHostAddress());
                }
                System.out.println("getNetworkPrefixLength : " + address.getNetworkPrefixLength());
                System.out.println();
            }
            System.out.println();
        }
    }

}
