package com.freenow.serviceEndpoints.getUsers;

import com.freenow.serviceEndpoints.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetUsersResponse extends BaseResponse {
    List<User> users;
}
