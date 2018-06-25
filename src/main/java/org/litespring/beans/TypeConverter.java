package org.litespring.beans;

/**
 * @author luqi
 * @data 2018/6/24
 */
public interface TypeConverter {

    <T> T convertIfNecessary(Object value, Class<T> requiredType) throws TypeMismatchException;
}
