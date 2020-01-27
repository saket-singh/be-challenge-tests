package com.freenow.serviceEndpoints.getPosts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.freenow.serviceEndpoints.BaseClient;
import com.freenow.utility.request.RequestHandler;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetPostsClient extends BaseClient {

    public GetPostsResponse getPostsForAUser(String userId) {
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
