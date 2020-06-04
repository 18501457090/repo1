package com.weibin.nio.selector;
import java.nio.channels.*;

import java.io.IOException;
import java.util.Set;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/25
 **/
public class CreationSelectorStudy {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        Selector selector = Selector.open();
        socketChannel.configureBlocking(false);

        Object attachment = new Object();
        socketChannel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ
                | SelectionKey.OP_WRITE,attachment);
        SelectionKey selectionKey = socketChannel.keyFor(selector);
        SelectableChannel channel = selectionKey.channel();
        Selector selector1 = selectionKey.selector();
        System.out.println((channel == socketChannel) + "  " + (selector == selector1));
        selector.select();
        Set<SelectionKey> keys = selector.keys();


        int i1 = selectionKey.interestOps();
        int i = selectionKey.readyOps();
        System.out.println(i1 & SelectionKey.OP_READ);
        System.out.println(i1 & SelectionKey.OP_WRITE);
        System.out.println(i1 & SelectionKey.OP_CONNECT);
        System.out.println(i1 & SelectionKey.OP_ACCEPT);
        System.out.println(" -  - -  - - -  -  -  - - - - ");
        System.out.println(i & SelectionKey.OP_READ);
        System.out.println(i & SelectionKey.OP_WRITE);
        System.out.println(i & SelectionKey.OP_CONNECT);
        System.out.println(i & SelectionKey.OP_ACCEPT);

        if (selectionKey.isReadable()){

        }

        if ((selectionKey.readyOps() & SelectionKey.OP_READ) != 0){
            // 这表示读操作已经准备就绪
        }

        System.out.println("channel is yet closed ? " + !socketChannel.isOpen());
        System.out.println("Selector is yet closed ? " + !selector.isOpen());




    }

}
