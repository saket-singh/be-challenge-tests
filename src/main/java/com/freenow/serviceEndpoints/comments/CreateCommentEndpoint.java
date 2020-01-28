package com.freenow.serviceEndpoints.comments;

import com.freenow.constants.Url;
import com.freenow.utility.ServiceEndpoint;
import com.freenow.utility.request.HttpMethod;
import com.freenow.utility.request.Param;
import com.freenow.utility.request.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class CreateCommentEndpoint implements ServiceEndpoint {

    private CreateCommentRequestBody createCommentRequestBody;

    public CreateCommentEndpoint(CreateCommentRequestBody createCommentRequestBody) {
        this.createCommentRequestBody = createCommentRequestBody;
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
        return null;
    }

    @Override
    public RequestBody body() {
        return new RequestBody(CreateCommentRequestBody.class, this.createCommentRequestBody);
    }
}
