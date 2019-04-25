package com.djlminispring.context;

import com.djlminispring.beans.factory.DefaultListableBeanFactory;
import com.djlminispring.beans.factory.ListableBeanFactory;
import com.djlminispring.beans.factory.config.BeanPostProcessor;
import com.djlminispring.exception.BeansException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * @Author: djl
 * @Date: 2019/4/25 11:13
 * @Version 1.0
 */
public abstract  class AbstractApplicationContext implements ApplicationContext,ListableBeanFactory{

    private ApplicationContext parent;

    protected String[] configLocations;

    protected DefaultListableBeanFactory beanFactory;

    public AbstractApplicationContext() {

    }

    public AbstractApplicationContext(ApplicationContext parent) {
        this.parent = parent;
    }



    @Override
    public Object getBean(String name) throws Exception {
        return this.beanFactory.getBean(name);
    }

    @Override
    public List<Object> getBeansForType(Class<?> type) throws Exception {
        return this.beanFactory.getBeansForType(type);
    }
    
    // 定义了ioc容器 注入bean的流程
    protected void refresh() throws Exception {
        DefaultListableBeanFactory beanFactory = obtainFreshBeanFactory();
        // 加载bean的具体逻辑交由子类去实现
        loadBeanDefinitions(beanFactory);
        registerBeanPostProcessors(beanFactory);
    }

    private void registerBeanPostProcessors(DefaultListableBeanFactory beanFactory) throws Exception{
        List beanPostProcessors = this.getBeansForType(BeanPostProcessor.class);
        for (Object beanPostProcessor : beanPostProcessors) {
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }


    private DefaultListableBeanFactory obtainFreshBeanFactory() {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        this.beanFactory = beanFactory;
        return this.beanFactory;
    }


    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory)
            throws BeansException, IOException, ParserConfigurationException, SAXException, ClassNotFoundException;


    public String[] getConfigLocations() {
        return configLocations;
    }

    /** 设置spring配置文件路径*/
    public void setConfigLocations(String... configLocations) {
        if (configLocations !=null) {
            this.configLocations = new String[configLocations.length];
            for(int i = 0 ; i < configLocations.length; i++) {
                this.configLocations[i] = configLocations[i].trim();
            }
        } else {
            this.configLocations = null;
        }
    }

    public DefaultListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(DefaultListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
}
