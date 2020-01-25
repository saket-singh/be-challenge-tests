package com.freenow.serviceEndpoints.getUsers;

import com.freenow.utility.request.RequestHandler;
import io.restassured.response.Response;

public class GetUsersClient {

    public GetUsersResponse getUsersResponse() {
        GetUsersEndpoint getUsersEndpoint = new GetUsersEndpoint();
        Response response = new RequestHandler().processRequest(getUsersEndpoint);
        GetUsersResponse getUsersResponse = response.as(GetUsersResponse.class);
        return getUsersResponse;
    }
}
