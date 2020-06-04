package com.weibin.thread;

import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/31
 **/
public class SyncSocketClosed extends Thread{

    private final Socket socket;

    public SyncSocketClosed(Socket socket){
        this.socket = socket;
    }

    public void interrupt(){
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            List<Runnable> runnables = executorService.shutdownNow();
            Thread thread = new Thread();
            socket.close();
        } catch (Exception e){

        } finally {
            super.interrupt();
        }
    }

}
