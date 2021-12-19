package com.mcena.jaxrsjerseydemo.model;


import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.*;

@XmlRootElement
public class Message {
    private long id;
    private String message;
    private Date dateCreated;
    private String author;
    @JsonbTransient //ignores hashmap serialization
    private Map<Long, Comment> commentMap = new HashMap<>();
    private List<Link> links = new ArrayList<>();

    public Message () {

    }

    public Message(long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.dateCreated = new Date();
        this.author = author;
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

    public Map<Long, Comment> getCommentMap() {
        return commentMap;
    }

    public void setCommentMap(Map<Long, Comment> commentMap) {
        this.commentMap = commentMap;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void addLink(String url, String rel) {
        Link link = new Link();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
    }
}
