package org.litespring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author luqi
 * @data 2018/6/17
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

    String getDescription();
}
