package com.freenow.serviceEndpoints.getPosts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freenow.serviceEndpoints.getUsers.User;
import com.freenow.utility.request.RequestHandler;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetPostsClient {

    private ObjectMapper mapper;

    public GetPostsClient() {
        mapper = new ObjectMapper();
    }

    public GetPostsResponse getPostsForAUser(String userId){
        GetPostsEndpoint getPostsEndpoint = new GetPostsEndpoint(userId);
        Response response = new RequestHandler().processRequest(getPostsEndpoint);
        List<Post> posts = new ArrayList<>();
        try {
            posts = mapper.readValue(response.getBody().asString(), new TypeReference<List<Post>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        GetPostsResponse getPostsResponse = new GetPostsResponse();
        getPostsResponse.setPosts(posts);
        getPostsResponse.setHttpStatusCode(response.getStatusCode());
        return getPostsResponse;
    }
}
