package org.litespring.util;

/**
 * @author luqi
 * @data 2018/6/17
 */
public class Assert {

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
