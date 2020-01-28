package com.freenow.serviceEndpoints.getPosts;

import com.freenow.constants.Url;
import com.freenow.utility.ServiceEndpoint;
import com.freenow.utility.request.HttpMethod;
import com.freenow.utility.request.Param;
import com.freenow.utility.request.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class GetPostsEndpoint implements ServiceEndpoint {

    private String userId;

    public GetPostsEndpoint(String userId) {
        this.userId = userId;
    }

    @Override
    public String url() {
        return String.format("%s/posts", Url.parentURL);
    }

    @Override
    public HttpMethod httpMethod() {
        return HttpMethod.GET;
    }

    @Override
    public List<Param> queryParameters() {
        ArrayList<Param> queryParams = new ArrayList<>();
        queryParams.add(new Param("userId", userId));
        return queryParams;
    }

    @Override
    public List<Param> pathParameters() {
        return null;
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
