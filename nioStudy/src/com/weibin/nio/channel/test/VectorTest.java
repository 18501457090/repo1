package com.weibin.nio.channel.test;
import java.util.concurrent.ConcurrentSkipListSet;
import	java.util.concurrent.CopyOnWriteArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/24
 **/
public class VectorTest {

    public static void main(String[] args) {
        List<Integer> list = new Vector<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            iterator.remove();
        }



    }

}
