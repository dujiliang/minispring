package com.djlminispring.beans.factory.config;

/**
 * @Author: djl
 * @Date: 2019/4/24 11:11
 * @Version 1.0
 */
public interface BeanPostProcessor {

    /**
     *  实例化bean的前置处理
     * @param bean
     * @param beanName
     * @return
     */
    Object postProcessBeforeInitialization(Object bean, String beanName);

    /**
     * 实例化bean的后置处理
     * @param bean
     * @param beanName
     * @return
     */
    Object postProcessAfterInitialization(Object bean, String beanName);
}
