package org.litespring.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * @author luqi
 * @data 2018/8/12
 */
public interface Advice extends MethodInterceptor {

    Pointcut getPointcut();
}