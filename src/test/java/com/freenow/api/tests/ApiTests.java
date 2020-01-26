package com.freenow.api.tests;

import com.freenow.serviceEndpoints.getUsers.GetUsersClient;
import com.freenow.serviceEndpoints.getUsers.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ApiTests {

    GetUsersClient getUsersClient;

    public ApiTests(){
        getUsersClient = new GetUsersClient();
    }

    @Test
    public void getAllUsers() {
        List<User> users = getUsersClient.getUsersResponse();
        Assert.assertEquals(getUsersClient.getHttpStatusCode(),200);
    }
}
