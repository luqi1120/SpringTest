package org.litespring.beans.factory;

import org.litespring.beans.ConstructorArgument;
import org.litespring.beans.PropertyValue;

import java.util.List;

/**
 * 这个类相当于xml中的<bean><bean/>标签
 * @author luqi
 * @data 2018/6/9
 */
public interface BeanDefinition {

    public static final String SCOPE_SINGLETON = "singleton";
    public static final String SCOPE_PROTOTYPE = "prototype";
    public static final String SCOPE_DEFAULT = "";

    boolean isSingleton();

    boolean isPrototype();

    String getScope();

    void setScope(String scope);

    String getBeanClassName();

    /**
     * 获取到<property> 这个对象
     * @return 返回对象的集合
     */
    List<PropertyValue> getPropertyValues();

    ConstructorArgument getConstructorArgument();

    String getID();

    boolean hasConstructorArgumentValues();

    Class<?> resolveBeanClass(ClassLoader beanClassLoader) throws ClassNotFoundException;

    Class<?> getBeanClass() throws IllegalStateException;

    boolean hasBeanClass();
}
