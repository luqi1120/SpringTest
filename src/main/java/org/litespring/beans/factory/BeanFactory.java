package org.litespring.beans.factory;

/**
 * @author luqi
 * @data 2018/6/9
 */
public interface BeanFactory {
//    BeanDefinition getBeanDefinition(String beanId);

    Object getBean(String beanId);

    /** 给定一个bean的 name 去获取这个bean对应的class */
    Class<?> getType(String name) throws NoSuchBeanDefinitionException;
}
