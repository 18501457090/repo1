package com.weibin.vm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import org.omg.CORBA.portable.InvokeHandler;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/4/17
 **/
public class DynamicProxyTest {
    interface IHello {
        void sayHello();
    }

    static class IHelloImpl implements IHello {
        @Override
        public void sayHello() {
            System.out.println("hello word");
        }
    }

    static class DynamicProxy implements InvocationHandler {
        Object old;

        Object bind(Object old) {
            this.old = old;
            return Proxy.newProxyInstance(old.getClass().getClassLoader(), old.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome to ");
            return method.invoke(old, args);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IHello hello = (IHello) new DynamicProxy().bind(new IHelloImpl());
        hello.sayHello();

    }




}
