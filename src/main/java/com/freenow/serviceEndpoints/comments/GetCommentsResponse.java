package com.freenow.serviceEndpoints.comments;

import com.freenow.serviceEndpoints.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetCommentsResponse extends BaseResponse {

    private List<Comment> comments;
}
