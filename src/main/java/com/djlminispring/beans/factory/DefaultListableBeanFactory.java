package com.djlminispring.beans.factory;

import com.djlminispring.beans.BeanDefinition;
import com.djlminispring.exception.BeanDefinitionStoreException;
import com.djlminispring.support.BeanDefinitionRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: djl
 * @Date: 2019/4/24 16:22
 * @Version 1.0
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry,ListableBeanFactory {


    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        if (beanName == null) {
            throw new BeanDefinitionStoreException("beanName must not be empty");
        }
        if(beanDefinitionMap.containsKey(beanName)) {
            beanDefinitionMap.remove(beanName);
        }
        beanDefinitionMap.put(beanName,beanDefinition);
    }

    @Override
    public List<Object> getBeansForType(Class<?> type) throws Exception {
        List<Object> beans = new ArrayList<Object>();
        for(Map.Entry<String, BeanDefinition> map : beanDefinitionMap.entrySet()) {
            if(type.isAssignableFrom((Class<BeanDefinition>)beanDefinitionMap.get(map.getKey()).getBeanClass())) {
                beans.add(getBean(map.getKey()));
            }
        }
        return beans;
    }
}
