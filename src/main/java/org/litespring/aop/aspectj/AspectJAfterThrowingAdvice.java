package org.litespring.aop.aspectj;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;

/**
 * @author luqi
 * @data 2018/8/12
 */
public class AspectJAfterThrowingAdvice extends AbstractAspectJAdvice  {



    public AspectJAfterThrowingAdvice(Method adviceMethod, AspectJExpressionPointcut pointcut, Object adviceObject) {

        super(adviceMethod, pointcut, adviceObject);
    }


    public Object invoke(MethodInvocation mi) throws Throwable {
        try {
            return mi.proceed();
        }
        catch (Throwable t) {
            invokeAdviceMethod();
            throw t;
        }
    }
}
