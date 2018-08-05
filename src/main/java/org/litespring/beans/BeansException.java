package org.litespring.beans;

/**
 * @author luqi
 * @data 2018/8/5
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);	}

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
