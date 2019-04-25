package com.djlminispring.io;

import java.net.MalformedURLException;

/**
 * @Author: djl
 * @Date: 2019/4/25 15:37
 * @Version 1.0
 */
public interface ResourceLoader {

    /**
     *  根据url获取resource信息
     * @param location
     * @return
     * @throws MalformedURLException
     */
    Resource getResource(String location) throws MalformedURLException;

}
