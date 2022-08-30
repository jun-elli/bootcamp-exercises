package com.bootcamp.blog.model;

import javax.persistence.Entity;

@Entity
public class Blog extends Publication{

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
