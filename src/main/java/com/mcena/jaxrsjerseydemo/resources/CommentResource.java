package com.mcena.jaxrsjerseydemo.resources;


import com.mcena.jaxrsjerseydemo.model.Comment;
import com.mcena.jaxrsjerseydemo.service.CommentService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

    private CommentService commentService = new CommentService();
    // messages/{messageId}/comments/
    @GET
    public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
        return commentService.getAllComments(messageId);
    }

    @GET
    // messages/{messageId}/comments/{commentId}
    @Path("/{commentId}")
    public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
        return commentService.getComment(messageId, commentId);
    }
    // messages/{messageId}/comments/
    @POST
    public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
        return commentService.addComment(messageId, comment);
    }
    @PUT
    // messages/{messageId}/comments/{commentId}
    @Path("/{commentId}")
    public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId, Comment comment) {
        return commentService.updateComment(messageId, commentId, comment);
    }

    @DELETE
    // messages/{messageId}/comments/{commentId}
    @Path("/{commentId}")
    public Comment deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
        return commentService.removeComment(messageId, commentId);
    }


}
