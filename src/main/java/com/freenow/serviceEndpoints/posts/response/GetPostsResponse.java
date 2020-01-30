package com.freenow.serviceEndpoints.posts.response;

import com.freenow.serviceEndpoints.base.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetPostsResponse extends BaseResponse {
    private List<Post> posts;
}
