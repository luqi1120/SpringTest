package org.litespring.test.vi;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.core.io.ClassPathResource;
import org.litespring.core.io.FileSystemResource;
import org.litespring.core.io.Resource;

import java.io.InputStream;

/**
 * @author luqi
 * @data 2018/6/17
 */
public class ResourceTest {

    @Test
    public void testClassPathResource() throws Exception {

        Resource r = new ClassPathResource("petstore-v1.xml");

        InputStream is = null;
        try {
            is = r.getInputStream();

            // 注意这里测试并不充分
            Assert.assertNotNull(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    @Test
    public void testFileSystemResource() throws Exception {

        Resource r = new FileSystemResource("/Users/luqi/spr/src/test/resources/petstore-v1.xml");

        InputStream is = null;
        try {
            is = r.getInputStream();

            // 注意这里测试并不充分
            Assert.assertNotNull(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
}
