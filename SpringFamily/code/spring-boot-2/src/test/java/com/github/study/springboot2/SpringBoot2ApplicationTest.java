package com.github.study.springboot2;


import com.github.study.springboot2.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: lxz
 * @Date: 2020/4/16 0016
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot2ApplicationTest {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void contextLoads(){
        System.out.println(employeeMapper.getEmpById(1));
    }

}