package com.freenow.serviceEndpoints.posts.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freenow.serviceEndpoints.base.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post extends BaseResponse {
    private int userId;
    private int id;
    private String title;
    private String body;
}
