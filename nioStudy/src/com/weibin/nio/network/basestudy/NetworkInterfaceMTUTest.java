package com.weibin.nio.network.basestudy;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/1
 **/
public class NetworkInterfaceMTUTest {

    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()){
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            System.out.println("网络设备名称：" + networkInterface.getName());
            System.out.println("网络设备显示名称：" + networkInterface.getDisplayName());
            System.out.println("是否为虚拟接口: " + networkInterface.isVirtual());
            System.out.println("获取网络设备最大传输单元(MTU) : " + networkInterface.getMTU());
            System.out.println("获取父接口：" + networkInterface.getParent());
            Enumeration<NetworkInterface> subInterfaces = networkInterface.getSubInterfaces();
            while (subInterfaces.hasMoreElements()){
                NetworkInterface nextElement = subInterfaces.nextElement();
                System.out.println("子接口网络设备名称 ： " + nextElement.getName());
                System.out.println("子接口网络设备显示名称：" + nextElement.getDisplayName());
                System.out.println("子接口是否为虚拟接口: " + nextElement.isVirtual());
                System.out.println("子接口获取网络设备最大传输单元(MTU) : " + nextElement.getMTU());
                System.out.println("子接口获取父接口：" + nextElement.getParent());
            }
            System.out.println(" ------------ E n d ----------");
        }

    }

}
