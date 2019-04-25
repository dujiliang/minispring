package com.djlminispring.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: djl
 * @Date: 2019/4/25 15:31
 * @Version 1.0
 */
public interface InputStreamSource {

    /**
     *  获取输入流
     * @return
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;
}
