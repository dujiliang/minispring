package com.djlminispring.exception;

/**
 * @Author: djl
 * @Date: 2019/4/24 16:17
 * @Version 1.0
 */
public class BeanDefinitionStoreException extends  RuntimeException{

    public BeanDefinitionStoreException() {
        super();
    }

    public BeanDefinitionStoreException(String message) {
        super(message);
    }

    public BeanDefinitionStoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanDefinitionStoreException(Throwable cause) {
        super(cause);
    }

    protected BeanDefinitionStoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
