package org.litespring.aop;

/**
 * @author luqi
 * @data 2018/8/11
 */
public interface Pointcut {

    MethodMatcher getMethodMatcher();

    String getExpression();
}
