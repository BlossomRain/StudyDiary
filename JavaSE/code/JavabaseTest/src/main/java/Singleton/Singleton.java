package Singleton;

/**
 * @Auther: lxz
 * @Date: 2020/3/18 0018
 * @Description: 单例模式的实现方式
 */

//饿汉式
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}

//懒汉式 延迟加载----线程安全问题
class SingletonLazy {

    private static SingletonLazy instance = null;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        if (instance == null) instance = new SingletonLazy();
        return instance;
    }
}

//懒汉式 线程安全改造
class SingletonLazySync {
    private static SingletonLazySync instance = null;

    private SingletonLazySync() {
    }

    //方式一,效率稍差
    public static synchronized SingletonLazySync getInstance() {
        if (instance == null) instance = new SingletonLazySync();
        return instance;
    }

    //方式二,
    public static SingletonLazySync getInstance1() {

        if (instance == null) {
            synchronized (SingletonLazySync.class) {
                if (instance == null) instance = new SingletonLazySync();
            }
        }
        return instance;
    }
}
