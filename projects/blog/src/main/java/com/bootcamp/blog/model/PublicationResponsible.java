package com.bootcamp.blog.model;

import javax.persistence.Embeddable;

@Embeddable
public class PublicationResponsible {
    String name;
    String office;
    String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
