package org.litespring.beans.factory.support;

import org.litespring.beans.PropertyValue;
import org.litespring.beans.SimpleTypeConverter;
import org.litespring.beans.factory.BeanDefinition;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.beans.factory.config.ConfigurableBeanFactory;
import org.litespring.exception.BeanCreationException;
import org.litespring.util.ClassUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author luqi
 * @data 2018/6/9
 * 实现 BeanDefinitionRegistry 为了把xml相关的业务抽离出去,实现java的单一原则
 */
public class DefaultBeanFactory extends DefaultSingletonBeanRegistry implements
        BeanDefinitionRegistry, ConfigurableBeanFactory {

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(64);
    private ClassLoader beanClassLoader;

    public DefaultBeanFactory() {

    }

    /**
     * 注册bean
     * @param beanID
     * @param bd
     */
    public void registerBeanDefinition(String beanID,BeanDefinition bd){
        this.beanDefinitionMap.put(beanID, bd);
    }

    /**
     * 根据id获取到bean
     * @param beanId
     * @return
     */
    public BeanDefinition getBeanDefinition(String beanId) {
        return this.beanDefinitionMap.get(beanId);
    }

    /**
     * 根据id 获取ben的实例
     * @param beanId
     * @return
     */
    public Object getBean(String beanId) {
        BeanDefinition bd = this.getBeanDefinition(beanId);
        if (bd == null) {
            return null;
        }
        if(bd.isSingleton()){
            Object bean = this.getSingleton(beanId);
            if(bean == null){
                bean = createBean(bd);
                this.registerSingleton(beanId, bean);
            }
            return bean;
        }
        return createBean(bd);
    }

    // 进行拆分
//    private Object createBean(BeanDefinition bd) {
//        ClassLoader cl = this.getBeanClassLoader();
//        String beanClassName = bd.getBeanClassName();
//        try {
//            Class<?> clz = cl.loadClass(beanClassName);
//            return clz.newInstance();
//        } catch (Exception e) {
//            throw new BeanCreationException("create bean for "+ beanClassName +" failed",e);
//        }
//    }

    private Object createBean(BeanDefinition bd) {
        // 创建实例
        Object bean = instantiateBean(bd);
        // 设置属性
        populateBean(bd, bean);

        return bean;

    }

    // 创建实例
    private Object instantiateBean(BeanDefinition bd) {
        ClassLoader cl = this.getBeanClassLoader();
        String beanClassName = bd.getBeanClassName();
        try {
            Class<?> clz = cl.loadClass(beanClassName);
            return clz.newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("create bean for "+ beanClassName +" failed",e);
        }
    }

    /**
     * 设置属性  和set注入
     * @param bd xml 中的<bean><bean/> 标签
     * @param bean 对应着 bean 中的Class = "" 就是实例对象
     */
    protected void populateBean(BeanDefinition bd, Object bean){

        // 获取property标签属性
        List<PropertyValue> pvs = bd.getPropertyValues();

        if (pvs == null || pvs.isEmpty()) {
            return;
        }

        BeanDefinitionValueResolver valueResolver = new BeanDefinitionValueResolver(this);

        // 使用 SimpleTypeConverter 进行类型转换
        SimpleTypeConverter converter = new SimpleTypeConverter();
        try{
            for (PropertyValue pv : pvs){
                String propertyName = pv.getName();

                // PropertyValue中的value 可能是 value 或者 ref
                Object originalValue = pv.getValue();

                // 获取到引用的实例 TODO 怎么就知道Runtime是ref或者value的实例呢?
                Object resolvedValue = valueResolver.resolveValueIfNecessary(originalValue);


                // 通过反射set注入
                // 这里bean是 PetStoreService
                BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());

                // 属性描述器, private public 修饰的属性
                PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
                for (PropertyDescriptor pd : pds) {
                    if(pd.getName().equals(propertyName)){

                        // resolvedValue 进行转换类型
                        Object convertedValue = converter.convertIfNecessary(resolvedValue, pd.getPropertyType());

                        // 这个其实就是 set 方法
                        pd.getWriteMethod().invoke(bean, convertedValue);
                        break;
                    }
                }


            }
        }catch(Exception ex){
            throw new BeanCreationException("Failed to obtain BeanInfo for class [" + bd.getBeanClassName() + "]", ex);
        }
    }

    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader = beanClassLoader;
    }

    public ClassLoader getBeanClassLoader() {
        return (this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader());
    }
}
