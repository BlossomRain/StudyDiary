package com.reflectionTest;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @Auther: lxz
 * @Date: 2020/3/22 0022
 * @Description: 测试反射机制
 */
public class ReflectionTest {
    //测试反射的常见用法

    //获取接口
    @Test
    public void testInterface() throws Exception {
        Class clazz = Class.forName("com.reflectionTest.Person");
        Class[] interfaces = clazz.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }
    }


    //获取父类及泛型
    @Test
    public void testSuper(){
        Class<Person> clazz = Person.class;
        Type type = clazz.getGenericSuperclass();//父类带泛型的
        ParameterizedType parameterizedType = (ParameterizedType) type;//转换成泛型类型
        //获取泛型
        Type[] arguments = parameterizedType.getActualTypeArguments();
        for (Type argument : arguments) {
            System.out.println(argument.getTypeName());
        }
    }


    //获取运行时类的方法结构
    @Test
    public void testMethod(){
        Class<Person> clazz = Person.class;

        Field[] fields = clazz.getDeclaredFields();
        Method[] methods = clazz.getDeclaredMethods();

       /* for (Field field : fields) {
            System.out.println(field);
            System.out.println(field.getType());
        }
        //注解
        Annotation[] annotations = fields[0].getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        for (Method method : methods) {
            Class<?> returnType = method.getReturnType();
            Parameter[] parameters = method.getParameters();
            System.out.println(returnType+"  "+parameters);
        }
        */
        Class<?>[] exceptionTypes = methods[0].getExceptionTypes();

    }


    //获取运行时类的所有属性
    @Test
    public void testFiled(){
        Class<Person> clazz = Person.class;

        Field[] fields = clazz.getFields();
        fields = clazz.getDeclaredFields();
        for (Field field : fields) {
//            System.out.println(field);
//            int modifiers = field.getModifiers();
//            System.out.println(Modifier.toString(modifiers));
            System.out.println(field.getType());
            System.out.println(field.getName());
        }
    }


    @Test   //获取对象
    public void testCons() throws Exception {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();

        Constructor<Person> cons = clazz.getDeclaredConstructor();
        Person per = cons.newInstance();

    }


    @Test   //简单演示
    public void testReflection() throws Exception, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<Person> clazz = Person.class;
        Constructor<Person> cons = clazz.getConstructor(String.class, int.class);
        //创建对象
        Person tom = cons.newInstance("Tom", 1);
        System.out.println(tom.getName() + "---" + tom.getAge());
        //修改属性
        Field age = clazz.getDeclaredField("age");
        age.set(tom, 2);

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        cons.setAccessible(true);
        show.invoke(tom);
    }

}
