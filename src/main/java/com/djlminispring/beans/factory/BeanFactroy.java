package com.djlminispring.beans.factory;

/**
 * @Author: djl
 * @Date: 2019/4/24 10:38
 * @Version 1.0
 */
public interface BeanFactroy {

    /**
     * 获取beanname 从容器中获取bean
     * @param name
     * @return
     * @throws Exception
     */
    Object getBean(String name) throws Exception;
}
