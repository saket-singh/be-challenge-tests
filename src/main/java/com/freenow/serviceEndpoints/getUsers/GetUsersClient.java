package com.freenow.serviceEndpoints.getUsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freenow.utility.request.RequestHandler;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetUsersClient {

    private ObjectMapper mapper;

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    private int httpStatusCode;

    public GetUsersClient(){
        mapper = new ObjectMapper();
    }

    public List<User> getUsersResponse() {
        GetUsersEndpoint getUsersEndpoint = new GetUsersEndpoint();
        Response response = new RequestHandler().processRequest(getUsersEndpoint);
        setHttpStatusCode(response.getStatusCode());
        List<User> usersList = new ArrayList<>();
        try {
            usersList = mapper.readValue(response.getBody().asString(), new TypeReference<List<User>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usersList;
    }
}
