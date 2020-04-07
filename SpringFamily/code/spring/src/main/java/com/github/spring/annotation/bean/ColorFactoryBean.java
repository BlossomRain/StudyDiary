package com.github.spring.annotation.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Auther: lxz
 * @Date: 2020/4/7 0007
 * @Description:
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
