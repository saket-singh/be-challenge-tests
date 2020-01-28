package com.freenow.serviceEndpoints.getPosts;

import com.freenow.constants.Url;
import com.freenow.serviceEndpoints.comments.CommentRequestBody;
import com.freenow.utility.ServiceEndpoint;
import com.freenow.utility.request.HttpMethod;
import com.freenow.utility.request.Param;
import com.freenow.utility.request.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class CreatePostEndpoint implements ServiceEndpoint {
    private PostRequestBody postRequestBody;

    public CreatePostEndpoint(PostRequestBody postRequestBody) {
        this.postRequestBody = postRequestBody;
    }

    @Override
    public String url() {
        return String.format("%s/comments", Url.parentURL);
    }

    @Override
    public HttpMethod httpMethod() {
        return HttpMethod.POST;
    }

    @Override
    public List<Param> queryParameters() {
        return null;
    }

    @Override
    public List<Param> pathParameters() {
        return null;
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
