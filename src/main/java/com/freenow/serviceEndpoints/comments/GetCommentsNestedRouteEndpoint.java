package com.freenow.serviceEndpoints.comments;

import com.freenow.constants.Url;
import com.freenow.utility.ServiceEndpoint;
import com.freenow.utility.request.HttpMethod;
import com.freenow.utility.request.Param;
import com.freenow.utility.request.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class GetCommentsNestedRouteEndpoint implements ServiceEndpoint {

    private String postId;

    public GetCommentsNestedRouteEndpoint(String postId) {
        this.postId = postId;
    }


    @Override
    public String url() {
        return String.format("%s/posts/{postId}/comments", Url.parentURL);
    }

    @Override
    public HttpMethod httpMethod() {
        return HttpMethod.GET;
    }

    @Override
    public List<Param> queryParameters() {
        return null;
    }

    @Override
    public List<Param> pathParameters() {
        ArrayList<Param> params = new ArrayList<>();
        params.add(new Param("postId", postId));
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
