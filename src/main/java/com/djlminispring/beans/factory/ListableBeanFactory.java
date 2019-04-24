package com.djlminispring.beans.factory;

import java.util.List;

/**
 * @Author: djl
 * @Date: 2019/4/24 10:50
 * @Version 1.0
 */
public interface ListableBeanFactory extends BeanFactroy{

    /**
     * 根据类型获取该类型所有的bean
     * @param type
     * @return
     * @throws Exception
     */
    List<Object> getBeansForType(Class<?> type) throws Exception;
}
