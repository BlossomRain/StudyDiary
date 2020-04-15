package com.gihub.study.springboot.pojo;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description:测试yaml语法和配置文件的读取,
 *
 */
@Component
//将配置文件中的属性映射到这个类里面
//@ConfigurationProperties(prefix = "person")
//加载指定的配置文件
@PropertySource(value = {"classpath:config/person.yaml"})
public class Person {
    private String name;
    private Integer age;
    private Map<String, String> hobbies;
    private Pet pet;

    public Person() {
    }

    public Person(String name, Integer age, Map<String, String> hobbies, Pet pet) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                ", pet=" + pet +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Map<String, String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Map<String, String> hobbies) {
        this.hobbies = hobbies;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
