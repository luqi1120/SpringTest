package org.litespring.context.support;

import org.litespring.core.io.ClassPathResource;
import org.litespring.core.io.Resource;

/**
 * @author luqi
 * @data 2018/6/17
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    public ClassPathXmlApplicationContext(String configFile) {
        super(configFile);

    }

    /**
     * 模版设计模式，从写父类的抽象方法
     * @param path
     * @return
     */
    @Override
    protected Resource getResourceByPath(String path) {

        return new ClassPathResource(path, this.getBeanClassLoader());
    }
}
