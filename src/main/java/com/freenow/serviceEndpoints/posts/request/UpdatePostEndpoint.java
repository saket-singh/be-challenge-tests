package com.freenow.serviceEndpoints.posts.request;

import com.freenow.constants.Url;
import com.freenow.utility.ServiceEndpoint;
import com.freenow.utility.request.HttpMethod;
import com.freenow.utility.request.Param;
import com.freenow.utility.request.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class UpdatePostEndpoint implements ServiceEndpoint {
    private PostRequestBody postRequestBody;

    public UpdatePostEndpoint(PostRequestBody postRequestBody) {
        this.postRequestBody = postRequestBody;
    }

    @Override
    public String url() {
        return String.format("%s/comments/{postId}", Url.parentURL);
    }

    @Override
    public HttpMethod httpMethod() {
        return HttpMethod.PUT;
    }

    @Override
    public List<Param> queryParameters() {
        return null;
    }

    @Override
    public List<Param> pathParameters() {
        ArrayList<Param> params = new ArrayList<>();
        params.add(new Param("postId", String.valueOf(postRequestBody.getId())));
        return params;
    }

    @Override
    public List<Param> headers() {
        ArrayList<Param> headers = new ArrayList<>();
        headers.add(new Param("Content-Type", "application/json"));
        return headers;
    }

    @Override
    public RequestBody body() {
        return new RequestBody(PostRequestBody.class, this.postRequestBody);
    }
}
