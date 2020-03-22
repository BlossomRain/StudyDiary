package com.containerTest;

import org.junit.Test;

import java.util.*;

/**
 * @Auther: lxz
 * @Date: 2020/3/20 0020
 * @Description:测试Collection接口及其子类的使用
 */
public class CollectionTest {

    //Set  方法测试
    @Test
    public void testSet() {

        HashSet hashSet = new HashSet();

        hashSet.add(123);
        hashSet.add(new Integer(12));
        hashSet.add(new Integer(12));


        TreeSet treeSet = new TreeSet();
        treeSet.add(12);
        treeSet.add(-12);
        treeSet.add(2);
        treeSet.add(-2);

        for (Object o : treeSet) {
            System.out.println(o);
        }


    }

    //List  方法测试 相比Collection方法多了索引
    @Test
    public void testList() {
        //不支持add,静态内部类
        List<String> list = Arrays.asList("1", "12", "31", "41", "1s", "1d", "d1", "t1", "a1");
        List arrayList = new ArrayList();
        //添加
        arrayList.addAll(list);
        arrayList.add(2, "BB");

        //查询
        Object o = arrayList.get(0);
        int i = arrayList.indexOf(o);
        int i1 = arrayList.lastIndexOf(o);

        //删除
        Object remove = arrayList.remove(1);

        //修改
        Object aa = arrayList.set(1, "AA");

        //子集
        List list1 = arrayList.subList(1, 4);

        System.out.println(list1);

    }

    //Interator测试
    @Test
    public void testIterator() {
        Collection coll = Arrays.asList(new String[]{"123", "456", "789"});
        Iterator iterator = coll.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }

    //Collection 方法测试

    @Test
    public void testCollection() {
        Collection coll = new ArrayList();
        //添加
        coll.add("AA");
        coll.add("bb");
        coll.add(123);
        coll.add(new Date());

        coll.addAll(coll);
        //获取长度
        int size = coll.size();


        //判断内容是否空
        boolean empty = coll.isEmpty();
        //调用的是equals方法
        boolean contains = coll.contains(123);
        boolean b = coll.containsAll(coll);

        //删除 清空
        boolean remove = coll.remove(123);
        boolean b1 = coll.removeAll(coll);
        coll.clear();

        //交集 相等 哈希值
        boolean b2 = coll.retainAll(coll);
        boolean equals = coll.equals(coll);
        int i = coll.hashCode();

        //转换为数组
        Object[] objects = coll.toArray();
        //基本类型的数组会识别为一个,但是引用类型会拆开,只能是一个数组,
        //多个的话依旧会识别为一个个对象
        //原因,泛型不支持基本数据类型,底层直接将参数赋值给一个ArrayList<>的内部的数组,
        //本质上还是操作参数传递的数组
        List list = Arrays.asList(new char[]{'1', '2'});
        System.out.println(list);

    }
}
