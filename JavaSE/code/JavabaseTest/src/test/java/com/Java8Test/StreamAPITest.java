package com.Java8Test;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Auther: lxz
 * @Date: 2020/3/24 0024
 * @Description:对streamAPI进行测试
 */
public class StreamAPITest {

    List<String> list = new ArrayList<String>();

    @Before
    @Test
    public void testBefore() {
        for (int i = 0; i < 10; i++) {
            list.add(Double.toString(Math.random() * 10));
        }
    }


    @Test
    public void testStreaAPI() {
        Stream<String> stream = list.stream();
//        Stream<String> parallelStream = list.parallelStream();
//        Arrays.stream()
//        Stream.of()
//        Stream.iterate()

        //过滤
        stream.filter(num -> Double.parseDouble(num) > 9).forEach(System.out::println);
        stream.limit(3).forEach(System.out::println);
        stream.skip(3).forEach(System.out::println);
        stream.distinct().forEach(System.out::println);
        //

    }

}
