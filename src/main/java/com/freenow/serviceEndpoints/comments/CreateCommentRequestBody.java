package com.freenow.serviceEndpoints.comments;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateCommentRequestBody {
    private String postId;
    private String name;
    private String email;
    private String body;
}
