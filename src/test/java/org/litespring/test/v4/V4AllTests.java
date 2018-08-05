package org.litespring.test.v4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author luqi
 * @data 2018/8/5
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ AutowiredAnnotationProcessorTest.class,
        ClassPathBeanDefinitionScannerTest.class, ClassReaderTest.class, DependencyDescriptorTest.class,
        InjectionMetadataTest.class, MetadataReaderTest.class, PackageResourceLoaderTest.class,
        XmlBeanDefinitionReaderTest.class })
public class V4AllTests {

}
