package com.freenow.serviceEndpoints.users.response;

import com.freenow.serviceEndpoints.base.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetUsersResponse extends BaseResponse {
    List<User> users;
}
