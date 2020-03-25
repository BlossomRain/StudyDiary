package com.reflectionTest;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: lxz
 * @Date: 2020/3/23 0023
 * @Description:
 */
public class DynamicProxy {
    /**
     * 1.根据被代理类获取代理类
     * 2.获取方法并调用
     */
    @Test
    public void test() {
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("四川麻辣烫");

    }


}

class ProxyFactory {
    /**
     * @param obj:被代理类
     * @Description: 根据被代理类获取代理类
     * @create: 2020/3/23 0023 21:50
     * @return: 代理类
     */
    public static Object getProxyInstance(Object obj) {
        Class clazz = obj.getClass();
        InvocationHandler handler = new MyInvocationHandler();
        ((MyInvocationHandler) handler).bind(obj);

        Object proxyInstance = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(),
                handler);

        return proxyInstance;
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object obj;//被代理类

    public void bind(Object obj) {
        this.obj = obj;
    }

    /**
     * @param proxy:  代理类
     * @param method: 代理类方法
     * @param args:   代理类方法需要的参数
     * @Description: 代理类被调用方法时候会调用invoke
     * @create: 2020/3/23 0023 22:03
     * @return: java.lang.Object
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //代理类对象调用的方法,即被代理类的方法
        Object invoke = method.invoke(obj, args);
        return invoke;
    }


}

interface Human {

    String getBelief();

    void eat(String food);

}

//被代理类
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I am SuperMan!";
    }

    @Override
    public void eat(String food) {
        System.out.println("super man is eating" + food);
    }
}