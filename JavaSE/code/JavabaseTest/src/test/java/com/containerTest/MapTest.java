package com.containerTest;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * @Auther: lxz
 * @Date: 2020/3/20 0020
 * @Description:Map接口的测试
 */
public class MapTest {

    @Test
    public void testMap(){

        HashMap hashMap = new HashMap();
        hashMap.put("1",123);
        hashMap.put("2",123);
        hashMap.put("3",123);

        hashMap.put("1",999);

        Set set = hashMap.keySet();
        Collection values = hashMap.values();
        Set set1 = hashMap.entrySet();
    }
}
