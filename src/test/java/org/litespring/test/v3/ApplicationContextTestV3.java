package org.litespring.test.v3;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.context.support.ClassPathXmlApplicationContext;
import org.litespring.service.v3.PetStoreService;

/**
 * @author luqi
 * @data 2018/7/1
 */
public class ApplicationContextTestV3 {

    @Test
    public void testGetBeanProperty() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("petstore-v3.xml");
        PetStoreService petStore = (PetStoreService) context.getBean("petStore");

        Assert.assertNotNull(petStore.getAccountDao());
        Assert.assertNotNull(petStore.getItemDao());
        Assert.assertEquals(1, petStore.getVersion());

    }
}
