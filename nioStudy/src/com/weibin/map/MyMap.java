package com.weibin.map;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/6/3
 **/
public class MyMap {



    

    private int hash(int key,int length){
        return key & length;
    }




    private static class Node<K,V>{
        private int hash;
        private Node<K,V> next;
        private K key;
        private V value;



    }


}
