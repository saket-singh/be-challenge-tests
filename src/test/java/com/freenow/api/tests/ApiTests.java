package com.freenow.api.tests;

import com.freenow.serviceEndpoints.getPosts.GetPostsClient;
import com.freenow.serviceEndpoints.getPosts.GetPostsResponse;
import com.freenow.serviceEndpoints.getUsers.GetUsersClient;
import com.freenow.serviceEndpoints.getUsers.GetUsersResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTests {

    GetUsersClient getUsersClient;
    GetPostsClient getPostsClient;

    public ApiTests() {
        getUsersClient = new GetUsersClient();
        getPostsClient = new GetPostsClient();
    }

    @Test
    public void getAllUsers() {
        GetUsersResponse getUsersResponse = getUsersClient.getUsers();
        Assert.assertEquals(getUsersResponse.getHttpStatusCode(), 200);
        GetPostsResponse getPostsResponse = getPostsClient.getPostsForAUser("2");
        Assert.assertEquals(getPostsResponse.getHttpStatusCode(), 200);
    }
}
