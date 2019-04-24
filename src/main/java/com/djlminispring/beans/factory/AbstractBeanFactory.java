package com.djlminispring.beans.factory;

import com.djlminispring.beans.BeanDefinition;
import com.djlminispring.beans.factory.config.BeanPostProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: djl
 * @Date: 2019/4/24 11:02
 * @Version 1.0
 */
public abstract  class AbstractBeanFactory implements BeanFactroy {

    protected final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(256);

    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>(256);

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    @Override
    public Object getBean(String name) throws Exception {
        return doGetBean(name);
    }

    /**
     * 容器中获取bean
     * @param name
     * @return
     * @throws Exception
     */
    public  Object doGetBean(String name) throws Exception {
        Object bean;
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("Bean named:" + name + "is not exist");
        }
        Object sharedInstance = singletonObjects.get(name);
        if (sharedInstance != null) {
            bean = getObjectForBeanInstance();
            return bean;
        }
        // createBean交由子类去真正实现
        sharedInstance = createBean(name, beanDefinition);
        return sharedInstance;
    }

    private Object getObjectForBeanInstance() {
        return null;
    }

    // 子类来实现新建bean实例的
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws Exception;

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }
}
