package com.mcena.jaxrsjerseydemo.model;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Date;

@XmlRootElement
public class Comment {
    private long id;
    private String message;
    private Date dateCreated;
    private String author;

    public Comment() {

    }

    public Comment(long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.author = author;
        this.dateCreated = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
