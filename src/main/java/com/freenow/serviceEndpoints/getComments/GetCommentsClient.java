package com.freenow.serviceEndpoints.getComments;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freenow.utility.request.RequestHandler;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetCommentsClient {
    private ObjectMapper mapper;

    public GetCommentsClient() {
        mapper = new ObjectMapper();
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
}
