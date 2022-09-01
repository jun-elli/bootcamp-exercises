package com.bootcamp.blog.model;

import javax.persistence.Entity;

@Entity
public class Book  extends Publication{

    private Integer pages;

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
