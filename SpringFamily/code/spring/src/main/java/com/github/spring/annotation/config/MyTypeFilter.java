package com.github.spring.annotation.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @Auther: lxz
 * @Date: 2020/4/7 0007
 * @Description:
 */
public class MyTypeFilter implements TypeFilter {
    /**
     * @param metadataReader:读取到的正在扫描的类的信息
     * @param metadataReaderFactory:可以获取任何类的信息
     * @Description:
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前扫描类的注解信息   类的信息  类的资源信息(路径)
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        Resource resource = metadataReader.getResource();
        System.out.println(classMetadata.getClassName());
        if (classMetadata.getClassName().contains("er")) {
            return true;
        }
        return false;
    }
}
