package org.litespring.beans.factory.xml;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.litespring.beans.PropertyValue;
import org.litespring.beans.factory.BeanDefinition;
import org.litespring.beans.factory.config.RuntimeBeanReference;
import org.litespring.beans.factory.config.TypedStringValue;
import org.litespring.beans.factory.support.BeanDefinitionRegistry;
import org.litespring.beans.factory.support.GenericBeanDefinition;
import org.litespring.core.io.Resource;
import org.litespring.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * xml 业务单独封装，实现java单一原则
 * @author luqi
 * @data 2018/6/17
 *
 * BeanDefinitionRegistry 定义了 注册BeanDefinition，获得BeanDefinition的接口，
 * 而 XmlBeanDefinitionReader只是解析XML，形成BeanDefinition， 这是两个完全不同的职责
 *
 * 现在和 BeanDefinitionRegistry 是 has-a 关系
 * 如果继承接口 子类和父类是 is-a 关系
 */
public class XmlBeanDefinitionReader {

    // 配置文件中的id
    private static final String ID_ATTRIBUTE = "id";

    // 配置文件中的class
    private static final String CLASS_ATTRIBUTE = "class";

    public static final String SCOPE_ATTRIBUTE = "scope";

    // 实现PropertyValue相关的代码
    public static final String PROPERTY_ELEMENT = "property";

    public static final String REF_ATTRIBUTE = "ref";

    public static final String VALUE_ATTRIBUTE = "value";

    public static final String NAME_ATTRIBUTE = "name";

    protected final Log logger = LogFactory.getLog(getClass());


    /**
     * 没有实现接口而是引入了这个接口
     */
    BeanDefinitionRegistry registry;

    /**
     * 构造器
     * @param registry
     */
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    /**
     * 用解析xml文件
     * @param resource
     */
    public void loadBeanDefinition(Resource resource) {
        InputStream is = null;
        try {

            // 使用ClassUtils 获取类加载器,使用类加载器变成流
//            ClassLoader cl = ClassUtils.getDefaultClassLoader();
//            is = cl.getResourceAsStream(configFile);

            is = resource.getInputStream();

            // 调动dom4j的方法
            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);

            // 获取<beans>标签
            Element root = doc.getRootElement();
            Iterator<Element> iter = root.elementIterator();

            // 遍历 beans下面的bean
            while (iter.hasNext()) {
                Element ele = iter.next();
                String id = ele.attributeValue(ID_ATTRIBUTE);
                String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
                BeanDefinition bd = new GenericBeanDefinition(id, beanClassName);

                // 判断scope是不是为null
                if (ele.attribute(SCOPE_ATTRIBUTE) != null) {
                    bd.setScope(ele.attributeValue(SCOPE_ATTRIBUTE));
                }

                // 保存在map中,当调用getBeanDefinition 时候直接去map中获取
                // this.beanDefinitionMap.put(id, bd);

                // 实现PropertyValue相关的
                parsePropertyElement(ele, bd);

                // 调用接口的组册方法
                this.registry.registerBeanDefinition(id,bd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 实现PropertyValue相关的代码
     */
    public void parsePropertyElement(Element beanElem, BeanDefinition bd) {

        // 获取所有 property 的标签
        Iterator iter= beanElem.elementIterator(PROPERTY_ELEMENT);
        while(iter.hasNext()){
            Element propElem = (Element)iter.next();

            // 获取 property 中的 name
            String propertyName = propElem.attributeValue(NAME_ATTRIBUTE);

            // 如果没有长度打印异常信息
            if (!StringUtils.hasLength(propertyName)) {
                logger.fatal("Tag 'property' must have a 'name' attribute");
                return;
            }


            // 获取到<property><property/>标签中 value = "" 或 ref = "" 的值,new一个property对象
            Object val = parsePropertyValue(propElem, bd, propertyName);
            PropertyValue pv = new PropertyValue(propertyName, val);

            // 增加到集合数组当中
            bd.getPropertyValues().add(pv);
        }

    }

    /**
     *
     * @param ele  每一条 <property><property/> 标签
     * @param bd   每一条 <bean><bean/> 标签
     * @param propertyName property 中的name
     * @return
     */
    public Object parsePropertyValue(Element ele, BeanDefinition bd, String propertyName) {
        String elementName = (propertyName != null) ?
                "<property> element for property '" + propertyName + "'" :
                "<constructor-arg> element";


        // 判断有没有 value 或 ref
        boolean hasRefAttribute = (ele.attribute(REF_ATTRIBUTE)!=null);
        boolean hasValueAttribute = (ele.attribute(VALUE_ATTRIBUTE) !=null);

        if (hasRefAttribute) {

            // refName 是 ref 的值
            String refName = ele.attributeValue(REF_ATTRIBUTE);
            if (!StringUtils.hasText(refName)) {
                logger.error(elementName + " contains empty 'ref' attribute");
            }
            RuntimeBeanReference ref = new RuntimeBeanReference(refName);
            return ref;
        }else if (hasValueAttribute) {
            TypedStringValue valueHolder = new TypedStringValue(ele.attributeValue(VALUE_ATTRIBUTE));

            return valueHolder;
        }
        else {

            // 如果遇到 RuntimeException 异常说明可能是 property 写的不对
            throw new RuntimeException(elementName + " must specify a ref or value");
        }
    }

}
