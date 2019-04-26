package com.djlminispring.support;

import com.djlminispring.beans.BeanDefinition;
import com.djlminispring.io.Resource;
import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: djl
 * @Date: 2019/4/25 16:36
 * @Version 1.0
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws IOException, ParserConfigurationException, SAXException, ClassNotFoundException {
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
            Document document = builder.parse(inputStream);
            registerBeanDefinitions(document,resource);
        } catch (Exception e) {
            
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    protected void registerBeanDefinitions(Document document, Resource resource) throws ClassNotFoundException{
        Element documentElement = document.getDocumentElement();
        doRegisterBeanDefinitions(documentElement);
    }

    /** beanDefinition 注册**/
    protected void doRegisterBeanDefinitions(Element documentElement) throws ClassNotFoundException{
        NodeList childNodes = documentElement.getChildNodes();
        for(int i = 0 ; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node instanceof Element) {
                Element element = (Element)node;
                parseDefaultElement(element);
            }
        }
    }

    protected void parseDefaultElement(Element element) throws ClassNotFoundException{
        processBeanDefinition(element);
    }

    /** 解析将文档解析为beanDefinition对象*/
    protected void processBeanDefinition(Element element) throws ClassNotFoundException{
        String name = element.getAttribute("id");
        String className = element.getAttribute("class");
        String initMethodName = element.getAttribute("init-method");
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setName(name);
        beanDefinition.setBeanClass(Class.forName(className));
        if (!StringUtils.isEmpty(initMethodName)) {
            beanDefinition.setInitMethodName(initMethodName);
        }
        getRegistry().registerBeanDefinition(name,beanDefinition);
    }


}
