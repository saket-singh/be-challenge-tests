package com.freenow.api.tests;

import com.freenow.serviceEndpoints.getUsers.GetUsersClient;
import com.freenow.serviceEndpoints.getUsers.GetUsersResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTests {

    GetUsersClient getUsersClient;

    public ApiTests() {
        getUsersClient = new GetUsersClient();
    }

    @Test
    public void getAllUsers() {
        GetUsersResponse getUsersResponse = getUsersClient.getUsers();
        Assert.assertEquals(getUsersResponse.getHttpStatusCode(), 200);
    }
}
