package com.weibin.nio.channel;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class TypeBufferDemo {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.putDouble(1.1D);
        buffer.putDouble(1.2D);
        buffer.putDouble(1.3D);
        buffer.putDouble(1.4D);
        buffer.flip();
        DoubleBuffer doubleBuffer = buffer.asDoubleBuffer();
        for (int i = 0; i < doubleBuffer.capacity(); i++){
            System.out.print(doubleBuffer.get(i) + "  ");
        }

        System.out.println();

        ByteBuffer allocate = ByteBuffer.allocate(16);
        allocate.putFloat(2.1F);
        allocate.putFloat(2.2F);
        allocate.putFloat(2.3F);
        allocate.putFloat(2.4F);
        allocate.flip();
        FloatBuffer floatBuffer = allocate.asFloatBuffer();
        for (int i = 0; i < floatBuffer.capacity(); i++){
            System.out.print(floatBuffer.get(i) + "  ");
        }

        System.out.println();

        ByteBuffer allocate1 = ByteBuffer.allocate(16);
        allocate1.putInt(2);
        allocate1.putInt(3);
        allocate1.putInt(4);
        allocate1.putInt(5);
        allocate1.flip();
        IntBuffer intBuffer = allocate1.asIntBuffer();
        for (int i = 0; i < intBuffer.capacity(); i++){
            System.out.print(intBuffer.get(i) + "  ");
        }

        System.out.println();




    }


}
