package com.weibin.thread;

import java.util.Date;
import java.util.Vector;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/20
 **/
public class VectorTest {

    static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args) {
        while (true){
            for (int i = 0 ; i < 10;i++){
                vector.add(i);
            }
            Thread removeThread = new Thread(()->{
                try {
                    for (int i = 0;i < vector.size();i++){
                        System.out.println("remove vector size : " + vector.size());
                        vector.remove(i);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                    System.exit(1);
                }
            });
            Thread printThread = new Thread(()->{
                try {
                    for (int i = 0;i < vector.size();i++){
                        System.out.println("print vector size : " + vector.size());
                        vector.get(i);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                    System.exit(1);
                }
            });
            removeThread.start();
            printThread.start();
            while (Thread.activeCount() > 20);


        }



    }

}
