package com.djlminispring.beans.factory;

import com.djlminispring.beans.BeanDefinition;
import com.djlminispring.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;

/**
 * @Author: djl
 * @Date: 2019/4/24 14:10
 * @Version 1.0
 */
public class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws Exception {
        return doCreateBean(beanName, beanDefinition);
    }


    private Object doCreateBean(String beanName, BeanDefinition beanDefinition) throws Exception{
        Object beanInstance = createBeanInstance(beanName, beanDefinition);
        beanInstance = initializeBean(beanName, beanInstance, beanDefinition);
        return beanInstance;
    }


    /** 利用java反射创建bean*/
    private Object createBeanInstance(String beanName, BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException {
        return beanDefinition.getBeanClass().newInstance();
    }

    private Object initializeBean(final String beanName, final Object beanInstance, BeanDefinition beanDefinition) throws Exception {
        Object exposedObject = beanInstance;

        // 对象的前置处理（调用BeanPostProcessor的初始化前方法）
        exposedObject = applyBeanPostProcessorsBeforeInitialization(beanName, exposedObject);
        //调用afterPropertiesSet方法
        invokeInitMethods(beanName, exposedObject, beanDefinition);
        //调用自定义init方法
        //调用BeanPostProcessor的初始化后方法
        exposedObject = applyBeanPostProcessorsAfterInitialization(beanName, exposedObject);
        return exposedObject;
    }

    /**调用BeanPostProcessor的初始化前方法*/
    private Object applyBeanPostProcessorsBeforeInitialization(String beanName, final Object existingBean) {
       Object result = existingBean;
       for(BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
           result = beanPostProcessor.postProcessBeforeInitialization(result, beanName);
           if(result == null) {
               return result;
           }
       }
       return result;
    }

    /**调用afterPropertiesSet方法 是否实现InitializingBean接口*/
    private void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception{
        boolean isInitializingBean = (bean instanceof InitializingBean);
        if (isInitializingBean) {
            ((InitializingBean)bean).afterPropertiesSet();
        }
        if (beanDefinition.getInitMethodName() != null) {
            invokeCustomInitMethod(beanName, bean, beanDefinition);
        }
    }

    /** 调用对象的初始化方法**/
    private void invokeCustomInitMethod(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception{
        String initMethodName = beanDefinition.getInitMethodName();
        Class beanClass = bean.getClass();
        Method initMethod = beanClass.getDeclaredMethod(initMethodName);
        initMethod.invoke(bean);
    }

    /** 调用BeanPostProcessor初始化后置方法**/
    private Object applyBeanPostProcessorsAfterInitialization(String beanName, final Object exposedObject) {
        Object result = exposedObject;
        for(BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            result = beanPostProcessor.postProcessAfterInitialization(result,beanName);
            if(result == null) {
                return result;
            }
        }
        return result;
    }
}
