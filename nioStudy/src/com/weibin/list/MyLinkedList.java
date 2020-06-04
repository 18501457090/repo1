package com.weibin.list;

import java.util.Objects;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/6/1
 **/
public class MyLinkedList<E> {


    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public void add(E element) {
        Node<E> node = new Node<>(last, element, null);
        if (first == null) {
            // 首次添加元素
            first = node;
        } else {
            last.next = node;
        }
        last = node;
        size++;
    }

    private int index;

    public void remove(E element) {
        Node<E> node = getByElement(element);
        if (node != null){
            Node<E> previous =  node.previous;
            Node<E> next = node.next;
            moved(index, previous, next);
        }
    }

    public void remove(int index){
        Node<E> node = getByIndex(index);
        if (node != null){
            Node<E> previous = node.previous;
            Node<E> next = node.next;
            moved(index,previous,next);
        }
    }

    private void moved(int index,Node<E> previous,Node<E> next){
        if (index == 0){
            this.first = next;
            this.first.previous = null;
            size--;
            return;
        }
        if (index == size - 1){
            this.last = previous;
            this.last.next = null;
            size--;
            return;
        }
        if (previous != null){
            previous.next = next;
        }
        if (next != null){
            next.previous = previous;
        }
        size--;
    }


    public E get(int index) {
        Node<E> node = getByIndex(index);
        return node == null ? null : node.element;
    }

    private Node<E> getByElement(E element){
        if (size > 0 && element != null && first != null && last != null){
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node != null){
                    if (node.element.equals(element)){
                        this.index = i;
                        return node;
                    }
                    node = node.next;
                }
            }
        }
        return null;
    }

    private int getSizeMedia(){
        return size >> 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyLinkedList)) return false;
        MyLinkedList<?> that = (MyLinkedList<?>) o;
        return size == that.size &&
                index == that.index &&
                Objects.equals(first, that.first) &&
                Objects.equals(last, that.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last, size, index);
    }

    private Node<E> getByIndex(int index){

        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (size > 0) {
            int media = getSizeMedia();
            Node<E> temp = null;
            if (index > media) {
                temp = last;
                for (int i = size - 1; i > index; i--) {
                    temp = temp.previous;
                }
            } else {
                temp = first;
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }
            }
            return temp;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (first != null) {
            Node next = first;
            while (next != null) {
                sb.append(next.element).append(",");
                next = next.next;
            }
            sb.setCharAt(sb.length() - 1, ']');
        } else {
            sb.append("]");
        }

        return sb.toString();
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.remove(3);
        System.out.println(list);
        System.out.println(list.size());
        //System.out.println(list.get(0));
    }


    private static class Node<E> {
        private Node<E> previous;
        private E element;
        private Node<E> next;

        private Node(Node<E> previous, E element, Node<E> next) {
            this.previous = previous;
            this.element = element;
            this.next = next;
        }

    }


}
