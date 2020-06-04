package com.weibin.nio.network;

import java.math.BigDecimal;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/1
 **/
public class IPComputer {

    public static void main(String[] args) {
        double pow = Math.pow(2, 32);
        BigDecimal ipv4 = new BigDecimal(pow);
        System.out.println("IPV4地址可以分配的数量为 ：" + ipv4.toString());

        double pow1 = Math.pow(2, 128);
        BigDecimal ipv6 = new BigDecimal(pow1);
        System.out.println("IPV6地址可以分配的数量为 ：" + ipv6.toString());
    }

}
