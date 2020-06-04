package com.weibin.vm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: Vm Args -Xms20m -Xmx20m -XX:HeapDumpOnOutOfMemoryError
 * @author: zwb
 * @Date: 2020/3/30
 **/
public class HeapOOP {

    public final int m = 0;

    static class OOMObject{

    }

    public static void main(String[] args) {

        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize方法执行了!!!");
    }



}
