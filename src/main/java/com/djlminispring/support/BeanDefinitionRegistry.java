package com.djlminispring.support;

import com.djlminispring.beans.BeanDefinition;

/**
 * @Author: djl
 * @Date: 2019/4/24 16:20
 * @Version 1.0
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册bean
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
