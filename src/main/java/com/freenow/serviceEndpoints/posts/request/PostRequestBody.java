package com.freenow.serviceEndpoints.posts.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostRequestBody {
    private int id;
    private int userId;
    private String title;
    private String body;

    public PostRequestBody(int userId, String title, String body){
        this.userId = userId;
        this.title = title;
        this.body = body;
    }
}
