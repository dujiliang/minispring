package com.djlminispring.beans;

/**
 * @Author: djl
 * @Date: 2019/4/24 10:28
 * @Version 1.0
 */
public class BeanDefinition {

    private String name;

    private String className;

    private volatile Class beanClass;

    private String initMethodName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }
}
