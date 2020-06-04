package com.weibin.vm;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/26
 **/
public class FinallyExecute {

    public static void main(String[] args) {
        test();
    }


    static void test(){
        try {
            System.out.println(1/0);
            System.out.println("1");
        } catch (Exception e){
            System.out.println("2");
            throw e;
        } finally {
            System.out.println("3");
        }
        System.out.println("4");
    }

}
