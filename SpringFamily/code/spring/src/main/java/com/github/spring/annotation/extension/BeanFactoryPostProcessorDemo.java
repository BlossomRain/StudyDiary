package com.github.spring.annotation.extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: lxz
 * @Date: 2020/4/8 0008
 * @Description:
 */

@Component
public class BeanFactoryPostProcessorDemo implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessorDemo");
        for (String o : beanFactory.getBeanDefinitionNames()) {
            System.out.println(o);
        }
    }
}
