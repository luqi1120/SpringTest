package org.litespring.beans.factory.config;

/**
 * @author luqi
 * @data 2018/6/17
 */
public interface SingletonBeanRegistry {

    void registerSingleton(String beanName, Object singletonObject);

    Object getSingleton(String beanName);
}
