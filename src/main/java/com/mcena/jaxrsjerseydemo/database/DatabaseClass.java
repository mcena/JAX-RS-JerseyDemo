package com.mcena.jaxrsjerseydemo.database;



import com.mcena.jaxrsjerseydemo.model.Comment;
import com.mcena.jaxrsjerseydemo.model.Message;
import com.mcena.jaxrsjerseydemo.model.Profile;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {
    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();
    private static Map<Long, Comment> comments = new HashMap<>();

    static {
        messages.put(1L, new Message(1, "First Message", "Marco"));
        messages.put(2L, new Message(2, "Second Message", "Cena"));
    }

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<String, Profile> getProfiles() {
        return profiles;
    }

    public static Map<Long, Comment> getComments() {
        return comments;
    }
}
