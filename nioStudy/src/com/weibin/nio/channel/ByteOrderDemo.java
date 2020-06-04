package com.weibin.nio.channel;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteOrderDemo {

    public static void main(String[] args) {
        int value = 123456789;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(value);
        //System.out.println(allocate.order());
        // 默认是大端
       /* for (int i = 0 ; i < allocate.capacity(); i++){
            System.out.print(allocate.get(i) + "   ");
        }*/
        System.out.println();
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putInt(value);
        /*for (int i = 0 ; i < byteBuffer.capacity(); i++){
            System.out.print(byteBuffer.get(i) + "   ");
        }*/
        test();

    }

    static void test(){
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.putInt(123);
        allocate.putInt(456);
        allocate.flip();
        System.out.println(allocate.getInt());
        System.out.println(allocate.getInt());


        ByteBuffer byteBuffer = ByteBuffer.wrap(allocate.array());
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getInt());

    }


}
