package org.litespring.beans.factory.config;

import org.litespring.beans.BeansException;

/**
 * @author luqi
 * @data 2018/8/5
 */
public interface BeanPostProcessor {

    Object beforeInitialization(Object bean, String beanName) throws BeansException;


    Object afterInitialization(Object bean, String beanName) throws BeansException;
}
