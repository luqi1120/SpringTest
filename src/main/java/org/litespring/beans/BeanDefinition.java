package org.litespring.beans;

import java.util.List;

/**
 * 给定一个字符串转化为数字
 * @author luqi
 * @data 2018/6/24
 */
public interface BeanDefinition {

    public static final String SCOPE_SINGLETON = "singleton";
    public static final String SCOPE_PROTOTYPE = "prototype";
    public static final String SCOPE_DEFAULT = "";

    public boolean isSingleton();
    public boolean isPrototype();
    String getScope();
    void setScope(String scope);

    public String getBeanClassName();

    public List<PropertyValue> getPropertyValues();
}
