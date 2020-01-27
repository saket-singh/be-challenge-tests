package com.freenow.serviceEndpoints.getComments;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetCommentsResponse {

    private List<Comment> comments;
}
