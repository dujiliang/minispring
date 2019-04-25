package com.djlminispring.exception;

/**
 * @Author: djl
 * @Date: 2019/4/25 14:06
 * @Version 1.0
 */
public class BeansException extends RuntimeException{

    public BeansException() {
        super();
    }

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeansException(Throwable cause) {
        super(cause);
    }

    protected BeansException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
