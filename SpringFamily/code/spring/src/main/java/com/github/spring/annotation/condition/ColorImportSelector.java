package com.github.spring.annotation.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Auther: lxz
 * @Date: 2020/4/7 0007
 * @Description:自定义需要导入的组件
 */
public class ColorImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.github.spring.annotation.bean.Red"};
    }
}
