package org.litespring.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.litespring.test.v2.*;
import org.litespring.test.vi.V1AllTest;

/**
 * @author luqi
 * @data 2018/6/24
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        V1AllTest.class,
        V2AllTest.class
})
public class AllTests {
}
