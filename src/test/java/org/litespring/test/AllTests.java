package org.litespring.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.litespring.test.v2.V2AllTest;
import org.litespring.test.v3.V3AllTest;
import org.litespring.test.vi.V1AllTest;

/**
 * @author luqi
 * @data 2018/6/24
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        V1AllTest.class,
        V2AllTest.class,
        V3AllTest.class
})
public class AllTests {
}
