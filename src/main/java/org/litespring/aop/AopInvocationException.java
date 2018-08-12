package org.litespring.aop;

/**
 * @author luqi
 * @data 2018/8/12
 */
@SuppressWarnings("serial")
public class AopInvocationException extends RuntimeException {

    /**
     * Constructor for AopInvocationException.
     *
     * @param msg the detail message
     */
    public AopInvocationException(String msg) {
        super(msg);
    }

    /**
     * Constructor for AopInvocationException.
     *
     * @param msg   the detail message
     * @param cause the root cause
     */
    public AopInvocationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
