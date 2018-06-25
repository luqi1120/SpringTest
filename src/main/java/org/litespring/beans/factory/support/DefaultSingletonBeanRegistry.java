package org.litespring.beans.factory.support;

import org.litespring.beans.factory.config.SingletonBeanRegistry;
import org.litespring.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author luqi
 * @data 2018/6/17
 */
public class DefaultSingletonBeanRegistry  implements SingletonBeanRegistry {

    // 使用map保存单例对象的实例
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>(64);

    public void registerSingleton(String beanName, Object singletonObject) {

        Assert.notNull(beanName, "'beanName' must not be null");

        /**
         * 从map中获取对象，如果用就抛出异常，如果没有就保存map中
         */
        Object oldObject = this.singletonObjects.get(beanName);
        if (oldObject != null) {
            throw new IllegalStateException("Could not register object [" + singletonObject +
                    "] under bean name '" + beanName + "': there is already object [" + oldObject + "] bound");
        }
        this.singletonObjects.put(beanName, singletonObject);

    }

    public Object getSingleton(String beanName) {

        return this.singletonObjects.get(beanName);
    }
}
