package org.litespring.beans.factory.config;

/**
 * 配置classLoader
 * @author luqi
 * @data 2018/6/17
 */
public interface ConfigurableBeanFactory extends AutowireCapableBeanFactory {

    /**
     * 如方法名
     * @param beanClassLoader
     */
    void setBeanClassLoader(ClassLoader beanClassLoader);

    /**
     * 如方法名
     * @return classLoader
     */
    ClassLoader getBeanClassLoader();
}
