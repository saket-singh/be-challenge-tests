package com.freenow.serviceEndpoints.getComments;

import com.freenow.serviceEndpoints.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetCommentsResponse extends BaseResponse {

    private List<Comment> comments;
}
