package com.reflectionTest;

import org.junit.Test;

/**
 * @Auther: lxz
 * @Date: 2020/3/23 0023
 * @Description:静态代理
 */
public class StaticProxy {
    @Test
    public void test(){

        ProxyClothFactory factory = new ProxyClothFactory(new NikeClothFactory());

        factory.produceCloth();
    }


}

interface ClothFactory {
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory {

    private ClothFactory factory;

    public ProxyClothFactory() {
    }

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    public ClothFactory getFactory() {
        return factory;
    }

    public void setFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("proxy factory preparing...");
        factory.produceCloth();
        System.out.println("proxy factory ending...");
    }
}

//被代理类

class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("Nike Factory produces clothes");
    }
}

