package com.weibin.nio.nio.selector;

import java.io.IOException;
import java.nio.channels.Selector;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/13
 **/
public class SelectIsCloseTest_1 {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        System.out.println("A isOpen ? : " + selector.isOpen());
        selector.close();
        System.out.println("B isOpen ? : " + selector.isOpen());
        selector.open();
        System.out.println("C isOpen ? : " + selector.isOpen());
        selector.wakeup();
        System.out.println("D isOpen ? : " + selector.isOpen());
    }
}
