package com.djlminispring.support;

import com.djlminispring.exception.BeanDefinitionStoreException;
import com.djlminispring.io.Resource;
import com.djlminispring.io.ResourceLoader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @Author: djl
 * @Date: 2019/4/25 15:29
 * @Version 1.0
 */
public interface BeanDefinitionReader {

    /***
     * 根据流加载beanDefinition
     * @param resource
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws ClassNotFoundException
     */
    void loadBeanDefinitions(Resource resource) throws IOException, ParserConfigurationException, SAXException, ClassNotFoundException;

    /**
     * 根据文件路径加载beanDefinition信息
     * @param locations
     * @throws BeanDefinitionStoreException
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    void loadBeanDefinitions(String... locations) throws BeanDefinitionStoreException, ParserConfigurationException, SAXException, IOException, ClassNotFoundException;

    /**
     * 获取ResourceLoader对象
     * @return
     */
    ResourceLoader getResourceLoader();
}
