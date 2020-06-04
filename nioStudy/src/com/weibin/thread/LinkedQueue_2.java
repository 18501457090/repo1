package com.weibin.thread;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/8
 **/
public class LinkedQueue_2<E> {

    private static class Node<E> {
        final E item;
        private volatile Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
        }
    }

    private static AtomicReferenceFieldUpdater<Node,Node> nextUpdapter =
            AtomicReferenceFieldUpdater.newUpdater(Node.class,Node.class,"next");



    public static void main(String[] args) {
        LinkedQueue_2 queue = new LinkedQueue_2();

    }

}
