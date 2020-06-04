package com.weibin.vm;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/16
 **/
public class FinalizerTest {


    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    System.out.println("fileName : " + fileName);
                    InputStream in = getClass().getResourceAsStream(fileName);
                    if (in == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[in.available()];
                    in.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        Object obj = loader.loadClass("com.weibin.vm.FinalizerTest");
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.weibin.vm.FinalizerTest);
    }


}
