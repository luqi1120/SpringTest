package org.litespring.beans.factory.config;

import org.litespring.beans.factory.BeanFactory;

/**
 * @author luqi
 * @data 2018/8/5
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    Object resolveDependency(DependencyDescriptor descriptor);
}
