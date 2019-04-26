package com.djlminispring;

/**
 * Created by wenbo.shen on 2017/12/18.
 */
public class UserService {

    private String name;

    public void hello() {
        System.out.println("hello");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
