package org.litespring.beans.factory;

/**
 * @author luqi
 * @data 2018/6/9
 */
public interface BeanFactory {
//    BeanDefinition getBeanDefinition(String beanId);

    Object getBean(String beanId);
}
