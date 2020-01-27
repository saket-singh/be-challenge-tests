package com.freenow.serviceEndpoints.getPosts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;
}
