package com.djlminispring.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author: djl
 * @Date: 2019/4/25 16:12
 * @Version 1.0
 */
public class UrlResource implements Resource {

    private URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = this.url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
