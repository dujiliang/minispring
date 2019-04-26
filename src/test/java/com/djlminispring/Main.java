package com.djlminispring;


import com.djlminispring.beans.factory.BeanFactroy;
import com.djlminispring.context.FileSystemXmlApplicationContext;



/**
 * Created by wenbo.shen on 2017/12/18.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BeanFactroy beanFactory = new FileSystemXmlApplicationContext("minispringframework.xml");
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.hello();
    }

}
