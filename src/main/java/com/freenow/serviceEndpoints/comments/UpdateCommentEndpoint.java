package com.freenow.serviceEndpoints.comments;

import com.freenow.constants.Url;
import com.freenow.utility.ServiceEndpoint;
import com.freenow.utility.request.HttpMethod;
import com.freenow.utility.request.Param;
import com.freenow.utility.request.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class UpdateCommentEndpoint implements ServiceEndpoint {
    private CommentRequestBody commentRequestBody;

    public UpdateCommentEndpoint(CommentRequestBody commentRequestBody) {
        this.commentRequestBody = commentRequestBody;
    }

    @Override
    public String url() {
        return String.format("%s/comments/{commentId}", Url.parentURL);
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
        params.add(new Param("commentId", String.valueOf(commentRequestBody.getId())));
        return params;
    }

    @Override
    public List<Param> headers() {
        return null;
    }

    @Override
    public RequestBody body() {
        return new RequestBody(CommentRequestBody.class, this.commentRequestBody);
    }
}
