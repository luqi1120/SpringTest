package org.litespring.beans.factory.support;

import org.litespring.beans.PropertyValue;
import org.litespring.beans.factory.BeanDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luqi
 * @data 2018/6/9
 */
public class GenericBeanDefinition implements BeanDefinition {

    private String id;

    private String beanClassName;

    private boolean singleton = true;
    private boolean prototype = false;

    // SCOPE_DEFAULT = ""
    private String scope = SCOPE_DEFAULT;


    List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();

    public GenericBeanDefinition(String id, String beanClassName) {
        this.id = id;
        this.beanClassName = beanClassName;
    }


    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }

    public boolean isSingleton() {
        return this.singleton;
    }
    public boolean isPrototype() {
        return this.prototype;
    }
    public String getScope() {
        return this.scope;
    }
    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope) || SCOPE_DEFAULT.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);

    }

    /**
     * 实现PropertyValue相关的代码
     * @return
     */
    public String getBeanClassName() {
        return this.beanClassName;
    }
}
