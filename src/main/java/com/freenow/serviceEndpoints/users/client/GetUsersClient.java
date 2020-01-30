package com.freenow.serviceEndpoints.users.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.freenow.serviceEndpoints.base.BaseClient;
import com.freenow.serviceEndpoints.users.request.GetUsersEndpoint;
import com.freenow.serviceEndpoints.users.response.GetUsersResponse;
import com.freenow.serviceEndpoints.users.response.User;
import com.freenow.utility.request.RequestHandler;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetUsersClient extends BaseClient {

    public GetUsersResponse getAllUsers() {
        GetUsersEndpoint getUsersEndpoint = new GetUsersEndpoint();
        Response response = new RequestHandler().processRequest(getUsersEndpoint);
        List<User> usersList = new ArrayList<>();
        try {
            usersList = mapper.readValue(response.getBody().asString(), new TypeReference<List<User>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        GetUsersResponse getUsersResponse = new GetUsersResponse();
        getUsersResponse.setUsers(usersList);
        getUsersResponse.setHttpStatusCode(response.getStatusCode());
        return getUsersResponse;
    }
}
