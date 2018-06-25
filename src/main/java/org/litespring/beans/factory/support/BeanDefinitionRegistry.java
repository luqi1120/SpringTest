package org.litespring.beans.factory.support;

import org.litespring.beans.factory.BeanDefinition;

/**
 * 获取beanDefinition
 * 定义了 注册BeanDefinition，获得BeanDefinition的接口，
 * @author luqi
 * @data 2018/6/17
 */
public interface BeanDefinitionRegistry {

    /**
     * 获得BeanDefinition
     * @param beanID id
     * @return BeanDefinition
     */
    BeanDefinition getBeanDefinition(String beanID);

    /**
     * 注册BeanDefinition
     * @param beanID id
     * @param db bd
     */
    void registerBeanDefinition(String beanID, BeanDefinition db);
}
