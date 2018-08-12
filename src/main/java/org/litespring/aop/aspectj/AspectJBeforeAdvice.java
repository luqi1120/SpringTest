package org.litespring.aop.aspectj;

import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInvocation;
/**
 * @author luqi
 * @data 2018/8/12
 */
public class AspectJBeforeAdvice extends AbstractAspectJAdvice {

    public AspectJBeforeAdvice(Method adviceMethod,AspectJExpressionPointcut pointcut,Object adviceObject){
        super(adviceMethod,pointcut,adviceObject);
    }

    public Object invoke(MethodInvocation mi) throws Throwable {
        //例如： 调用TransactionManager的start方法
        this.invokeAdviceMethod();
        Object o = mi.proceed();
        return o;
    }
}
