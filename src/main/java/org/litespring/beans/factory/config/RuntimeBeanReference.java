package org.litespring.beans.factory.config;

/**
 * 每一条 <property><property/> 标签 中的 ref = "" 的值
 * @author luqi
 * @data 2018/6/24
 */
public class RuntimeBeanReference {

    private final String beanName;

    public RuntimeBeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return this.beanName;
    }
}
