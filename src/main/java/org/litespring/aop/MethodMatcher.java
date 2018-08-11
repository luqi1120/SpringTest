package org.litespring.aop;

import java.lang.reflect.Method; /**
 * @author luqi
 * @data 2018/8/11
 */
public interface MethodMatcher {

    boolean matches(Method method /*, Class<?> targetClass*/);
}
