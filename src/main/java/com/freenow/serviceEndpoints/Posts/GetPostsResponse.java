package com.freenow.serviceEndpoints.Posts;

import com.freenow.serviceEndpoints.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetPostsResponse extends BaseResponse {
    private List<Post> posts;
}
