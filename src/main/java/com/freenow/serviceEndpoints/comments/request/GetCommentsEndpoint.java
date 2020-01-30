package com.freenow.serviceEndpoints.comments.request;

import com.freenow.constants.Url;
import com.freenow.utility.ServiceEndpoint;
import com.freenow.utility.request.HttpMethod;
import com.freenow.utility.request.Param;
import com.freenow.utility.request.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class GetCommentsEndpoint implements ServiceEndpoint {

    private String postId;
    private int commentId;

    public GetCommentsEndpoint() {
        commentId = 0;
    }

    public GetCommentsEndpoint(String postId) {
        this.postId = postId;
    }

    public GetCommentsEndpoint(int commentId) {
        this.commentId = commentId;
    }

    @Override
    public String url() {
        return String.format("%s/comments/{commentId}", Url.parentURL);
    }

    @Override
    public HttpMethod httpMethod() {
        return HttpMethod.GET;
    }

    @Override
    public List<Param> queryParameters() {
        if (postId != null) {
            ArrayList<Param> queryParams = new ArrayList<>();
            queryParams.add(new Param("postId", postId));
            return queryParams;
        } else
            return null;
    }

    @Override
    public List<Param> pathParameters() {
            ArrayList<Param> params = new ArrayList<>();
        if (commentId != 0) {
            params.add(new Param("commentId", String.valueOf(commentId)));
        }else
            params.add(new Param("commentId", ""));
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
