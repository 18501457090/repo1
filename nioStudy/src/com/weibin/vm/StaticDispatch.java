package com.weibin.vm;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/16
 **/
public class StaticDispatch {

    static abstract class Human{}

    static class Man extends Human {}

    static class Woman extends Human{}

    public void sayHello(Human guy) {
        System.out.println("hello guy!");
    }
    public void sayHello(Man guy) {
        System.out.println("hello man guy!");
    }
    public void sayHello(Woman guy) {
        System.out.println("hello Woman guy!");
    }

    public static void main(String[] args) {
        // 静态类型
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch dispatch = new StaticDispatch();
        // 静态类型变化
        dispatch.sayHello(man);
        dispatch.sayHello(woman);
    }


    static void s(){
        Man man = new Man();
        Woman woman = new Woman();
        StaticDispatch dispatch = new StaticDispatch();
        // 静态类型变化
        dispatch.sayHello((Man)man);
        dispatch.sayHello((Woman) woman);
    }


}
