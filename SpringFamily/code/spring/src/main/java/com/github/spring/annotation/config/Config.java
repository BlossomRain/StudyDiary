package com.github.spring.annotation.config;

import com.github.spring.annotation.bean.Car;
import com.github.spring.annotation.bean.Color;
import com.github.spring.annotation.bean.ColorFactoryBean;
import com.github.spring.annotation.bean.Person;
import com.github.spring.annotation.condition.ColorImportSelector;
import com.github.spring.annotation.condition.WindowsCondition;
import org.springframework.context.annotation.*;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @Auther: lxz
 * @Date: 2020/4/7 0007
 * @Description:配置类
 */
@ComponentScan(value = "com.github.spring.annotation"//指定要扫描的包
//                excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
//                classes = {Controller.class, Service.class})}//指定要不扫描的类型的
//        includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})},
//        useDefaultFilters = false
)

@Import(value = {Color.class, ColorImportSelector.class})
@Configuration//配置类等同与配置文件
public class Config {
    @Lazy
//    @Scope(value = "prototype")        //配置单例,多例
    @Bean("person")//告诉spring配置一个Person对象,id名为方法名
    public Person person() {
        return new Person("David", 1);
    }

    @Conditional({WindowsCondition.class})
    @Bean("conditionalPerson")
    public Person conditionalPerson() {
        return new Person("ConditionalPerson", 1);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}
