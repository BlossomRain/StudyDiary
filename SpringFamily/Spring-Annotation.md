# Spring注解版

​											--------笔记来源:尚硅谷-雷丰阳

前置课程:seedling: spring基本学习  spring-mvc 

## 1. 配置类

```java
//配置类
@ComponentScan(value = "com.github.spring.annotation",//指定要扫描的包
                excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
                classes = {Controller.class, Service.class})}//指定要不扫描的类型的
)
@Configuration//配置类等同与配置文件
public class Config {
    @Scope
    @Bean("person")//告诉spring配置一个Person对象,id名为方法名
    public Person person() {
        return new Person("David", 1);
    }
}
```

```java
//main方法中
private AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
```

### 1.1@ComponentScan  指定扫描的过滤规则

```java
public enum FilterType {
	ANNOTATION,//根据注解类型
	ASSIGNABLE_TYPE,//根据指定类型,包括子类也会算进去
	ASPECTJ,
	REGEX,
	/** Filter candidates using a given custom
	 * {@link org.springframework.core.type.filter.TypeFilter} implementation.
	 */
	CUSTOM//自定义类型,需要实现上面注释中的接口

}
```

### 1.2@Scope 指定单例,多例

```java
/*@Scope 中value取值
* @see ConfigurableBeanFactory#SCOPE_PROTOTYPE ----多例,获取对象的时候才实例化
* @see ConfigurableBeanFactory#SCOPE_SINGLETON ----单例,默认IOC创建就会实例化对象了,可以设置懒加载@Lazy
* @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST ---request域
* @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION ---session域
*/
```

### 1.3@Conditional

```java
//@Conditional只有满足条件才能生效
public class WindowsCondition implements Condition {//实现该接口,在注解中用这个类,
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //1. 获取当前环境的bean工厂
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2. 获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3. 获取环境变量
        Environment environment = context.getEnvironment();
        //4. bean注册定义类
        BeanDefinitionRegistry registry = context.getRegistry();
        if (environment.getProperty("os.name").contains("Windows")){
            return true;
        }
        return false;
    }
}
```

### 1.4注册组件的方式

```java
@Controller 等注解
@Bean
@Import   	{@link Configuration}, //实现该接口
			{@link ImportSelector}, //实现该接口,返回全类名数组,不要返回null,会引发空指针异常
			{@link ImportBeanDefinitionRegistrar} //手动注册类
			{随便其他类}
@FactoryBean    
			1.默认获取到的是getObject返回的对象
             2.可以在getBean("&...")获取工厂本身
```

### 1.5生命周期

```java
1.@Bean(initMethod = "init", destroyMethod = "destroy")
//单例时候, 对象初始化完成后自动调用init方法,容器关闭销毁
//多例时候,关闭容器不会销毁
    
2.//通过实现以下两个接口也可达到上面的效果
org.springframework.beans.factory.InitializingBean
org.springframework.beans.factory.DisposableBean  
    
3.  //这两个注解见名知意
    javax.annotation.PostConstruct
    javax.annotation.PreDestroy
4. BeanPostProcessor //接口,完成一些后置处理工作  ,初始化工作前后,构造器后面  
```