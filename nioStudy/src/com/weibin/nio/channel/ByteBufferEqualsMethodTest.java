package com.weibin.nio.channel;

import java.nio.ByteBuffer;

public class ByteBufferEqualsMethodTest {

    public static void main(String[] args) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[]{1, 2, 3, 4, 5});
        ByteBuffer wrap1 = ByteBuffer.wrap(new byte[]{ 2, 3, 4, 5});
        wrap.get();
        // 两个缓冲区的capacity可以不相同，
        // equals()方法比较的是position到limit之间的内容是否完全一致
        System.out.println(wrap.equals(wrap1));
    }

}
