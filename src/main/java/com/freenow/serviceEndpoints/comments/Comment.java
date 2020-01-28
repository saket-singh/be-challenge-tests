package com.freenow.serviceEndpoints.comments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;
}
