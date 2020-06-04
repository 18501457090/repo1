package com.weibin.thread;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/9
 **/
public class ResourceFactory {


    private static class ResourceHolder{
        public static final ResourceFactory INSTANCE = new ResourceFactory();
    }

    public static ResourceFactory getInstance(){
        return ResourceHolder.INSTANCE;
    }

    public static volatile ResourceFactory INSTANCE;

    public static ResourceFactory getInstance1(){
        if (INSTANCE == null){
            synchronized (ResourceFactory.class){
                if (INSTANCE == null){
                    INSTANCE = new ResourceFactory();
                }
            }
        }
        return INSTANCE;
    }


}
