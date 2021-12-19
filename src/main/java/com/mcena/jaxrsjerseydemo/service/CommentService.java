package com.mcena.jaxrsjerseydemo.service;


import com.mcena.jaxrsjerseydemo.database.DatabaseClass;
import com.mcena.jaxrsjerseydemo.model.Comment;
import com.mcena.jaxrsjerseydemo.model.Message;
import jakarta.ws.rs.WebApplicationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentService {
    private Map<Long, Message> messageMap = DatabaseClass.getMessages();

    public CommentService() {

    }

    public List<Comment> getAllComments(long messageId) {
        Map<Long,Comment> commentMap = messageMap.get(messageId).getCommentMap();
        return new ArrayList<Comment>(commentMap.values());
    }

    public Comment getComment(long messageId, long commentId) {
        Message message = messageMap.get(messageId);
        if(message == null) {
            throw new WebApplicationException();
        }
        Map<Long, Comment> commentMap = messageMap.get(messageId).getCommentMap();
        Comment comment = commentMap.get(commentId);
        if(comment == null) {
            throw new WebApplicationException();
        }
        return commentMap.get(commentId);
    }

    public Comment addComment(long messageId, Comment comment) {
        Map<Long, Comment> commentMap = messageMap.get(messageId).getCommentMap();
        comment.setId(commentMap.size() + 1);
        commentMap.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(long messageId, long commentId, Comment comment) {
        Map<Long, Comment> commentMap = messageMap.get(messageId).getCommentMap();
        if (comment.getId() <= 0 ) {
            return null;
        }
        commentMap.put(commentId, comment);
        return comment;
    }

    public Comment removeComment(long messageId, long commentId) {
        Map<Long, Comment> commentMap = messageMap.get(messageId).getCommentMap();
        return commentMap.remove(commentId);
    }
}
