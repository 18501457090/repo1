package com.weibin.nio.nio.selector;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/1/14
 **/
public class ManyThreadSelectorTest {

    public static void main(String[] args) throws InterruptedException {
        Set set = new HashSet();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        new Thread(()->{
            try {
                Thread.sleep(500);
                set.remove("1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Thread.sleep(1000);
            iterator.next();
        }
    }



}
