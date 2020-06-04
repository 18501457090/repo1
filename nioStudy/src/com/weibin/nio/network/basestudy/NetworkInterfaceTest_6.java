package com.weibin.nio.network.basestudy;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/2
 **/
public class NetworkInterfaceTest_6 {

    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()){
            NetworkInterface nextElement = interfaces.nextElement();
            System.out.println("网络设备名称：" + nextElement.getName());
            System.out.println("网络设备显示名称：" + nextElement.getDisplayName());
            // 每一个NetworkInterface拥有多个InterfaceAddress和多个InetAddress
            List<InterfaceAddress> interfaceAddresses = nextElement.getInterfaceAddresses();
            Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();

            if (Objects.nonNull(interfaceAddresses)){
                interfaceAddresses.forEach((address)->{
                    InetAddress address1 = address.getAddress();
                    System.out.println("HostName: " + address1.getHostName());
                    System.out.println("HostAddress: " + address1.getHostAddress());
                });
            }
        }
    }


}
