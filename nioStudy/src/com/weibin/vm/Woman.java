package com.weibin.vm;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/16
 **/
public class Woman extends Human {


    public static void main(String[] args) throws IOException {
       /* List<Integer> integers = Arrays.asList(9, 4, 5, 6, 2, 1);
        boolean empty = integers.isEmpty();
        System.out.println(empty);
        Collections.sort(integers);
        System.out.println(integers);*/
       ;
        System.out.println(test(20));

    }

    // 1,1,2,3,5,8,13,21
    static int test(int n){
        System.out.println(n);
        if (n == 0){
            return n;
        } else if (n == 1){
            return n;
        } else if (n == 2){
            return 1;
        } else {
            return test(n - 1) + test(n - 2);
        }




    }

}
