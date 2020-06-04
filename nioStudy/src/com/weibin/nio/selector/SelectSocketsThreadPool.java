package com.weibin.nio.selector;
import java.io.IOException;
import	java.nio.channels.SelectionKey;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/27
 **/
public class SelectSocketsThreadPool {


    private class ThreadPool {
        final List<Thread> idle = new LinkedList<Thread>();

        ThreadPool(int poolSize) {
            for (int i = 0; i < poolSize; i++) {
                WorkerThread thread = new WorkerThread(this);
                thread.setName("Worker " + (i + 1));
                thread.start();
                idle.add(thread);
            }
        }

        WorkerThread getWorker(){
            WorkerThread thread = null;
            synchronized (idle){
                if (idle.size() > 0){
                    thread = (WorkerThread) idle.remove(0);
                }
            }
            return thread;
        }

        void addWorker(WorkerThread thread){
            synchronized (idle){
                idle.add(thread);
            }
        }

    }

    private class WorkerThread extends Thread {
        private ByteBuffer buffer = ByteBuffer.allocate(1024);
        private ThreadPool threadPool;
        private SelectionKey key;
        WorkerThread(ThreadPool pool){
            this.threadPool = pool;
        }

        @Override
        public synchronized void run(){
            System.out.println(this.getName()  + " is Ready");
            while (true){
                try {
                    this.wait();
                } catch (Exception e){
                    e.printStackTrace();
                    this.interrupt();
                }
                if (key == null){
                    continue;
                }
                try {
                    this.drainChannel(key);
                } catch (Exception e){
                    e.printStackTrace();
                    try {
                        key.channel().close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    key.selector().wakeup();
                }
                key = null;
                this.threadPool.addWorker(this);
            }
        }

        synchronized void serviceChannel(SelectionKey key){
            this.key = key;
            key.interestOps(key.interestOps() & (~SelectionKey.OP_READ));
            this.notify();
        }

        void drainChannel(SelectionKey key) throws IOException {
            SocketChannel channel = (SocketChannel) key.channel();
            int count;
            buffer.clear();
            while ((count = channel.read(buffer)) > 0){
                buffer.flip();
                while (buffer.hasRemaining()){
                    channel.write(buffer);
                }
                buffer.clear();
            }
            if (count < 0){
                channel.close();
                return;
            }
            key.interestOps(key.interestOps() | SelectionKey.OP_READ);
            key.selector().wakeup();
        }

    }


}
