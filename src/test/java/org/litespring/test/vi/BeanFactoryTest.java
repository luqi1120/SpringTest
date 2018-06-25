package org.litespring.test.vi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.litespring.beans.factory.BeanDefinition;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.core.io.ClassPathResource;
import org.litespring.service.vi.PetStoreService;

/**
 * @author luqi
 * @data 2018/6/9
 */
public class BeanFactoryTest {

    // DefaultBeanFactory 实现了BeanDefinitionRegistry, 而XmlBeanDefinitionReader就是为了解析xml文件的
    // XmlBeanDefinitionReader有一个构造器需要传入BeanDefinitionRegistry接口的实例
    DefaultBeanFactory factory;
    XmlBeanDefinitionReader reader;

    /**
     * 在每次测试用力之前每一个测试用力都会调用这个方法
     */
    @Before
    public void setUp() {
        // DefaultBeanFactory 实现了BeanDefinitionRegistry, 而XmlBeanDefinitionReader就是为了解析xml文件的
        // XmlBeanDefinitionReader有一个构造器需要传入BeanDefinitionRegistry接口的实例
        factory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(factory);
    }

    // 给定一个配置文件获取bean的定义
    @Test
    public void testGetBean() {

        // 首先获取bean DefaultBeanFactory解析xml返回bean
        // BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");

        // DefaultBeanFactory 实现了BeanDefinitionRegistry, 而XmlBeanDefinitionReader就是为了解析xml文件的
        // XmlBeanDefinitionReader有一个构造器需要传入BeanDefinitionRegistry接口的实例
        reader.loadBeanDefinition(new ClassPathResource("petstore-v1.xml"));

        // 传入id获取类
        BeanDefinition bd = factory.getBeanDefinition("petStore");

        /** 判断是不是单例 */
        Assert.assertTrue(bd.isSingleton());

        Assert.assertFalse(bd.isPrototype());

        Assert.assertEquals(BeanDefinition.SCOPE_DEFAULT,bd.getScope());

        Assert.assertEquals("org.litespring.service.vi.PetStoreService", bd.getBeanClassName());

        PetStoreService petStore = (PetStoreService)factory.getBean("petStore");

        Assert.assertNotNull(petStore);

        /** 在次获得对象判断是否相等 看看是不是单利 */
        PetStoreService petStore1 = (PetStoreService)factory.getBean("petStore");

        Assert.assertTrue(petStore.equals(petStore1));
    }

    // 测试异常
//    @Test
//    public void testInvalidBean() {
////        DefaultBeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
//        DefaultBeanFactory factory = new DefaultBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        reader.loadBeanDefinition("petstore-v1.xml");
//
//        try {
//            factory.getBean("invalidBean");
//        } catch (BeanCreationException e) {
//            return ;
//        }
//        Assert.fail("Exception BeanCreationException");
//    }
}
