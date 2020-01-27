package com.freenow.serviceEndpoints.getComments;

import com.freenow.constants.Url;
import com.freenow.utility.ServiceEndpoint;
import com.freenow.utility.request.HttpMethod;
import com.freenow.utility.request.Param;
import com.freenow.utility.request.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class GetCommentsEndpoint implements ServiceEndpoint {

    private String postId;

    public GetCommentsEndpoint(String postId) {
        this.postId = postId;
    }

    @Override
    public String url() {
        return String.format("%s/comments", Url.parentURL);
    }

    @Override
    public HttpMethod httpMethod() {
        return HttpMethod.GET;
    }

    @Override
    public List<Param> queryParameters() {
        ArrayList<Param> queryParams = new ArrayList<>();
        queryParams.add(new Param("postId", postId));
        return queryParams;
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
