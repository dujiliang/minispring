package com.djlminispring.context;

import com.djlminispring.beans.factory.DefaultListableBeanFactory;
import com.djlminispring.exception.BeansException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @Author: djl
 * @Date: 2019/4/25 14:48
 * @Version 1.0
 */
public abstract class AbstractXmlApplicationContext extends AbstractApplicationContext{

    public AbstractXmlApplicationContext() {

    }

    /** 暂时不知道为什么这么设置**/
    public AbstractXmlApplicationContext(AbstractApplicationContext parent) {
        super(parent);
    }

    @Override
    protected  void loadBeanDefinitions(DefaultListableBeanFactory beanFactory)
            throws BeansException, IOException, ParserConfigurationException, SAXException, ClassNotFoundException{

    }
}
