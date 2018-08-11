package org.litespring.test.v5;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.aop.MethodMatcher;
import org.litespring.aop.aspectj.AspectJExpressionPointcut;
import org.litespring.service.v5.PetStoreService;

/**
 * AOP 第一步
 * 给定一个字符串，把字符串转换为一个对象，让这个对象去matcher，看一个类中的方法是不是符合这个表达式
 * @author luqi
 * @data 2018/8/11
 */
public class PointcutTest {

    @Test
    public void testPointcut() throws Exception{

        String expression = "execution(* org.litespring.service.v5.*.placeOrder(..))";

        AspectJExpressionPointcut pc = new AspectJExpressionPointcut();
        pc.setExpression(expression);

        MethodMatcher mm = pc.getMethodMatcher();

        {
            Class<?> targetClass = PetStoreService.class;

            Method method1 = targetClass.getMethod("placeOrder");
            Assert.assertTrue(mm.matches(method1));

            Method method2 = targetClass.getMethod("getAccountDao");
            Assert.assertFalse(mm.matches(method2));
        }

        {
            Class<?> targetClass = org.litespring.service.v4.PetStoreService.class;

            Method method = targetClass.getMethod("getAccountDao");
            Assert.assertFalse(mm.matches(method));
        }

    }
}
