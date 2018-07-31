package org.litespring.beans.factory.annotation;

import org.litespring.beans.factory.BeanDefinition;
import org.litespring.core.type.AnnotationMetadata;

/**
 * @author luqi
 * @data 2018/7/30
 */
public interface AnnotatedBeanDefinition extends BeanDefinition {
    AnnotationMetadata getMetadata();
}
