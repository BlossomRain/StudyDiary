package com.iotest;

import org.junit.Test;

import java.io.*;

/**
 * @Auther: lxz
 * @Date: 2020/3/22 0022
 * @Description:对象流处理
 */
public class ObjectInputTest {

    /**
     * @Description: 序列化过程, 使用obj输出
     */
    @Test
    public void testObjectOutput() throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));
            oos.writeObject(new Person("aaa",1));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //反序列化过程,文件中读取一个对象
    @Test
    public void testObjectInput() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Object.dat"));
            Object o = ois.readObject();

            System.out.println(o.getClass()+"  "+o);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null)

                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }


    }

}

class Person implements Serializable{

    public static final long serialVersionUID = 123321L;

    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}