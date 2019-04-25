package com.djlminispring.support;

import com.djlminispring.io.Resource;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
            
        }
    }

    private void registerBeanDefinitions(Document document, Resource resource) throws ClassNotFoundException{
        Element documentElement = document.getDocumentElement();
        doRegisterBeanDefinitions(documentElement);
    }

    private void doRegisterBeanDefinitions(Element documentElement) throws ClassNotFoundException{
        
    }
}
