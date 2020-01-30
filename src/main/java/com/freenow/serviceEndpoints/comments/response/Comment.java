package com.freenow.serviceEndpoints.comments.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freenow.serviceEndpoints.base.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment extends BaseResponse {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;
}
