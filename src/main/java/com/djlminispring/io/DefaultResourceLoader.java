package com.djlminispring.io;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: djl
 * @Date: 2019/4/25 16:10
 * @Version 1.0
 */
public class DefaultResourceLoader implements  ResourceLoader{

    @Override
    public Resource getResource(String location) throws MalformedURLException {
        URL url = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(url);
    }
}
