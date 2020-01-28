package com.freenow.serviceEndpoints.comments;

import com.fasterxml.jackson.core.type.TypeReference;
import com.freenow.serviceEndpoints.BaseClient;
import com.freenow.utility.request.RequestHandler;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommentsClient extends BaseClient {

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

    public Comment createANewCommentForAPost(String postId, String name, String email, String body) {
        CreateCommentRequestBody createCommentRequestBody = new CreateCommentRequestBody(postId, name, email, body);
        CreateCommentEndpoint createCommentEndpoint = new CreateCommentEndpoint(createCommentRequestBody);
        Response response = new RequestHandler().processRequest(createCommentEndpoint);
        Comment comment = response.as(Comment.class);
        return comment;
    }
}
