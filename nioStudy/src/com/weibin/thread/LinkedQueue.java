package com.weibin.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/8
 **/
public class LinkedQueue<E> {

    private static class Node<E> {
        final E item;
        final AtomicReference<Node<E>> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = new AtomicReference<Node<E>>();
        }
    }

    private final Node<E> dummy = new Node<E>(null, null);
    private final AtomicReference<Node<E>> head = new AtomicReference<Node<E>>(dummy);
    private final AtomicReference<Node<E>> tail = new AtomicReference<Node<E>>(dummy);

    public boolean put(E item) {
        Node<E> newNode = new Node<E>(item, null);
        while (true) {
            Node<E> currTail = tail.get();
            Node<E> tailNext = currTail.next.get();
            System.out.println(currTail.next.get());
            if (currTail == tail.get()) {
                if (tailNext != null) { /* A：队列处于中间状态,去推进尾节点 */
                    tail.compareAndSet(currTail, tailNext);/* B */
                } else {
                    if (currTail.next.compareAndSet(null, newNode)) {/* C */
                        tail.compareAndSet(currTail, newNode); /* D */
                        return true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.put("1111");
        queue.put("1111");
        queue.put("1111");
        queue.put("1111");
    }

}
