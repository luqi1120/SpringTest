package org.litespring.beans.factory.config;

import org.litespring.beans.BeansException;

/**
 * @author luqi
 * @data 2018/8/5
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{

    Object beforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

    boolean afterInstantiation(Object bean, String beanName) throws BeansException;

    void postProcessPropertyValues(Object bean, String beanName) throws BeansException;
}
