package com.compareTest;


import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Auther: lxz
 * @Date: 2020/3/19 0019
 * @Description:比较器的使用
 */
public class CompareTest {

    @Test
    public void test() {
        String[] arr = new String[]{"aa", "bb", "cc", "dd"};
        Arrays.sort(arr);

        Mouse[] mouses = new Mouse[3];
        mouses[0] = new Mouse("a", 1.2);
        mouses[1] = new Mouse("b", 1.2);
        mouses[2] = new Mouse("b", 1.1);

        Arrays.sort(mouses);

        for (int i = 0; i < mouses.length; i++) {
            System.out.println(mouses[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = o1;
                    String s2 = o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("class error");
            }
        });

        System.out.println(Arrays.toString(arr));

    }


}

class Mouse implements Comparable {

    String name;

    @Override
    public String toString() {
        return "Mouse{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    double price;

    public Mouse(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {


        if (o instanceof Mouse) {

            if (this.price > ((Mouse) o).price) return 1;
            if (this.price < ((Mouse) o).price) return -1;
            return this.name.compareTo(((Mouse) o).name);
        }
        throw new RuntimeException("类型错误");
    }
}