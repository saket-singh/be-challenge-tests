package com.freenow.serviceEndpoints.comments;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentRequestBody {
    private String id;
    private String postId;
    private String name;
    private String email;
    private String body;

    public CommentRequestBody(String postId, String name, String email, String body){
        this.postId = postId;
        this.name = name;
        this.email = email;
        this.body = body;
    }
}
