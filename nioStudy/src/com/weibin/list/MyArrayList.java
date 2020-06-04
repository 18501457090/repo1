package com.weibin.list;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/6/1
 **/
public class MyArrayList<E> {

    Object[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return this.size;
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        elements = new Object[capacity];
    }

    public boolean add(E element) {
        this.scale();
        elements[size++] = element;
        return false;
    }

    public E get(int index) {
        this.checkRange(index);
        return (E) this.elements[index];
    }

    public void set(int index, E element) {
        this.checkRange(index);
        this.elements[index] = element;
    }

    public void remove(E element){
        if (element == null){
            return;
        }
        for (int i = 0; i < size; i++){
            if (elements[i].equals(element)){
                this.remove(i);
                break;
            }
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void remove(int index) {
        this.checkRange(index);
        int numMoved = this.elements.length - index - 1;
        if (numMoved > 0){
            System.arraycopy(this.elements,index + 1,elements,index,numMoved);
        }
        this.elements[--size] = null;
    }

    private void checkRange(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void scale() {
        if (this.size == elements.length) {
            int newCapacity = elements.length + (elements.length >> 1);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.size; i++) {
            sb.append(elements[i]).append(",");
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        MyArrayList<String> arrayList = new MyArrayList<>(2);
        for (int i = 0; i < 10; i++) {
            arrayList.add("面试 " + i);
        }

        arrayList.remove(1);
        System.out.println(arrayList);
        System.out.println(arrayList.get(1));

    }


}
