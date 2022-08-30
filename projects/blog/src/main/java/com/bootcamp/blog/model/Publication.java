package com.bootcamp.blog.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Publication {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private Date createdDate;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="name", column=@Column(name = "editor_name")),
            @AttributeOverride(name="office", column=@Column(name = "editor_office")),
            @AttributeOverride(name="category", column=@Column(name = "editor_category")),
    })
    private PublicationResponsible editor;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="name", column=@Column(name = "supervisor_name")),
            @AttributeOverride(name="office", column=@Column(name = "supervisor_office")),
            @AttributeOverride(name="category", column=@Column(name = "supervisor_category")),
    })
    private PublicationResponsible supervisor;


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public PublicationResponsible getEditor() {
        return editor;
    }

    public void setEditor(PublicationResponsible editor) {
        this.editor = editor;
    }

    public PublicationResponsible getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(PublicationResponsible supervisor) {
        this.supervisor = supervisor;
    }


}
