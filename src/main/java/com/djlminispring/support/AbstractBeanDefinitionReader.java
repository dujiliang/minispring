package com.djlminispring.support;

import com.djlminispring.exception.BeanDefinitionStoreException;
import com.djlminispring.io.DefaultResourceLoader;
import com.djlminispring.io.Resource;
import com.djlminispring.io.ResourceLoader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @Author: djl
 * @Date: 2019/4/25 16:06
 * @Version 1.0
 */
public abstract  class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    protected final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
        this.resourceLoader = new DefaultResourceLoader();
    }

    @Override
    public void loadBeanDefinitions(String... locations) throws BeanDefinitionStoreException, ParserConfigurationException, SAXException, IOException, ClassNotFoundException{
        ResourceLoader resourceLoader = getResourceLoader();
        for(String location : locations) {
            Resource resource = resourceLoader.getResource(location);
            // 此处具体的就给子类去实现（加载类需要先去解析bean的xml或者是相关注解）
            loadBeanDefinitions(resource);
        }
    }

    public BeanDefinitionRegistry getRegistry() {
        return this.registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }
}
