package org.litespring.test.vi;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author luqi
 * @data 2018/6/17
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ApplicationContextTest.class,
        BeanFactoryTest.class,
        ResourceTest.class
})
public class V1AllTest {
}
