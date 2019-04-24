package com.djlminispring.beans.factory;

/**
 * @Author: djl
 * @Date: 2019/4/24 14:41
 * @Version 1.0
 */
public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
