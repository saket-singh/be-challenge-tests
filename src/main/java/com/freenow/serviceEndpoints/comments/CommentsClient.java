package com.freenow.serviceEndpoints.comments;

import com.fasterxml.jackson.core.type.TypeReference;
import com.freenow.serviceEndpoints.BaseClient;
import com.freenow.utility.request.RequestHandler;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommentsClient extends BaseClient {


    public GetCommentsResponse getAllComments() {
        GetCommentsEndpoint getCommentsEndpoint = new GetCommentsEndpoint();
        Response response = new RequestHandler().processRequest(getCommentsEndpoint);
        List<Comment> comments = new ArrayList<>();
        try {
            comments = mapper.readValue(response.getBody().asString(), new TypeReference<List<Comment>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        GetCommentsResponse getCommentsResponse = new GetCommentsResponse();
        getCommentsResponse.setComments(comments);
        getCommentsResponse.setHttpStatusCode(response.getStatusCode());
        return getCommentsResponse;
    }

    public GetCommentsResponse getCommentsForAUser(String postId) {
        GetCommentsEndpoint getCommentsEndpoint = new GetCommentsEndpoint(postId);
        Response response = new RequestHandler().processRequest(getCommentsEndpoint);
        List<Comment> comments = new ArrayList<>();
        try {
            comments = mapper.readValue(response.getBody().asString(), new TypeReference<List<Comment>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        GetCommentsResponse getCommentsResponse = new GetCommentsResponse();
        getCommentsResponse.setComments(comments);
        getCommentsResponse.setHttpStatusCode(response.getStatusCode());
        return getCommentsResponse;
    }

    public Comment createANewCommentForAPost(int postId, String name, String email, String body) {
        CommentRequestBody commentRequestBody = new CommentRequestBody(postId, name, email, body);
        CreateCommentEndpoint createCommentEndpoint = new CreateCommentEndpoint(commentRequestBody);
        Response response = new RequestHandler().processRequest(createCommentEndpoint);
        Comment comment = response.as(Comment.class);
        comment.setHttpStatusCode(response.statusCode());
        return comment;
    }

    public Comment updateAnExistingCommentForAPost(int id, int postId, String name, String email, String body) {
        CommentRequestBody commentRequestBody = new CommentRequestBody(id, postId, name, email, body);
        UpdateCommentEndpoint updateCommentEndpoint = new UpdateCommentEndpoint(commentRequestBody);
        Response response = new RequestHandler().processRequest(updateCommentEndpoint);
        Comment comment = response.as(Comment.class);
        comment.setHttpStatusCode(response.statusCode());
        return comment;
    }

    public GetCommentsResponse getCommentsResponseForNestedRoute (String postId) {
        GetCommentsNestedRouteEndpoint getCommentsNestedRouteEndpoint = new GetCommentsNestedRouteEndpoint(postId);
        Response response = new RequestHandler().processRequest(getCommentsNestedRouteEndpoint);
        List<Comment> comments = new ArrayList<>();
        try {
            comments = mapper.readValue(response.getBody().asString(), new TypeReference<List<Comment>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        GetCommentsResponse getCommentsResponse = new GetCommentsResponse();
        getCommentsResponse.setComments(comments);
        getCommentsResponse.setHttpStatusCode(response.getStatusCode());
        return getCommentsResponse;
    }
}
