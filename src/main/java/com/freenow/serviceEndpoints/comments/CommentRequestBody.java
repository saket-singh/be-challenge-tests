package com.freenow.serviceEndpoints.comments;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentRequestBody {
    private int id;
    private int postId;
    private String name;
    private String email;
    private String body;

    public CommentRequestBody(int postId, String name, String email, String body){
        this.postId = postId;
        this.name = name;
        this.email = email;
        this.body = body;
    }
}
