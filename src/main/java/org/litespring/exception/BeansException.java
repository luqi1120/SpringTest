package org.litespring.exception;

/**
 * @author luqi
 * @data 2018/6/9
 */
public class BeansException extends RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
