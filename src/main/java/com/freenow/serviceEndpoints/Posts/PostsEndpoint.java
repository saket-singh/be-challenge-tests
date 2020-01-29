package com.freenow.serviceEndpoints.Posts;

import com.freenow.constants.Url;
import com.freenow.utility.ServiceEndpoint;
import com.freenow.utility.request.HttpMethod;
import com.freenow.utility.request.Param;
import com.freenow.utility.request.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class PostsEndpoint implements ServiceEndpoint {

    private String userId;
    private int postId;
    private HttpMethod httpMethod;

    public PostsEndpoint(HttpMethod httpMethod) {
        postId = 0;
        this.httpMethod = httpMethod;
    }

    public PostsEndpoint(String userId, HttpMethod httpMethod) {
        this.userId = userId;
        this.httpMethod = httpMethod;
    }

    public PostsEndpoint(int postId, HttpMethod httpMethod) {
        this.postId = postId;
        this.httpMethod = httpMethod;
    }

    @Override
    public String url() {
        return String.format("%s/posts/{postId}", Url.parentURL);
    }

    @Override
    public HttpMethod httpMethod() {
        return httpMethod;
    }

    @Override
    public List<Param> queryParameters() {
        if (userId != null) {
            ArrayList<Param> queryParams = new ArrayList<>();
            queryParams.add(new Param("userId", userId));
            return queryParams;
        } else
            return null;
    }

    @Override
    public List<Param> pathParameters() {
        ArrayList<Param> params = new ArrayList<>();
        if (postId != 0) {
            params.add(new Param("postId", String.valueOf(postId)));
        } else
            params.add(new Param("postId", ""));
        return params;
    }

    @Override
    public List<Param> headers() {
        return null;
    }

    @Override
    public RequestBody body() {
        return null;
    }
}
