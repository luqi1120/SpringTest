package org.litespring.exception;

/**
 * @author luqi
 * @data 2018/6/9
 */
public class BeanCreationException extends BeansException {

    private String beanName;

    public BeanCreationException(String message) {
        super(message);
    }

    public BeanCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanCreationException(String beanName, String message) {
        super("Error creating bean with name" + beanName + " : " + message);
        this.beanName = beanName;
    }

    public BeanCreationException(String message, Throwable cause, String beanName) {
        this(beanName, message);
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
