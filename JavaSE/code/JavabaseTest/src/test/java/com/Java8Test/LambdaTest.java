package com.Java8Test;

import org.junit.Test;

/**
 * @Auther: lxz
 * @Date: 2020/3/24 0024
 * @Description:Lambda表达式的测试
 * 
 */
public class LambdaTest {
    
    //简单实用
    @Test
    public void testLambda(){
        Runnable run = ()-> System.out.println("Lambda expression test");
        run.run();


    }
    
}
