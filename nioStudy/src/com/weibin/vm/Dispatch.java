package com.weibin.vm;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/17
 **/
public class Dispatch {

    /**单分派多分派演示**/
    static class QQ{}
    static class _360{}
    public static class Father{
        public void hardChoice(QQ arg){
            System.out.println("father choose qq");
        }
        public void hardChoice(_360 var){
            System.out.println("father choose 360");
        }
    }
    public static class Son extends Father{
        public void hardChoice(QQ arg){
            System.out.println("son choose qq");
        }
        public void hardChoice(_360 var){
            System.out.println("son choose 360");
        }
    }
    public static void main(String[] args) {
        // 静态多分派
        // 1.静态类型是Father还是Son
        Father father = new Father();
        Father son = new Son();
        //二是方法参数: 是QQ还是360
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }

    public int clac(){
        int a = 100;
        int b = 200;
        int c = 300;
        return (a + b) * c;
    }



}
