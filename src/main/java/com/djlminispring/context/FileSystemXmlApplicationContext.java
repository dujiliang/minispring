package com.djlminispring.context;

/**
 * @Author: djl
 * @Date: 2019/4/26 10:51
 * @Version 1.0
 */
public class FileSystemXmlApplicationContext extends AbstractXmlApplicationContext {

    public FileSystemXmlApplicationContext() {

    }

    public FileSystemXmlApplicationContext(ApplicationContext parent) {
        super(parent);
    }

    public FileSystemXmlApplicationContext(String configLocation) throws Exception {
        this(new String[]{configLocation}, true, null);
    }
    public FileSystemXmlApplicationContext(String... configLocations) throws Exception {
        this(configLocations, true, null);
    }

    public FileSystemXmlApplicationContext(String[] configLocations, boolean refresh, ApplicationContext parent)
            throws Exception {
        super(parent);
        setConfigLocations(configLocations);
        if (refresh) {
            refresh();
        }
    }
}
