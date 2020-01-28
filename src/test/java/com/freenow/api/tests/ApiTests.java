package com.freenow.api.tests;

import com.freenow.helpers.EmailIdValidator;
import com.freenow.serviceEndpoints.getComments.GetCommentsClient;
import com.freenow.serviceEndpoints.getComments.GetCommentsResponse;
import com.freenow.serviceEndpoints.getPosts.GetPostsClient;
import com.freenow.serviceEndpoints.getPosts.GetPostsResponse;
import com.freenow.serviceEndpoints.getPosts.Post;
import com.freenow.serviceEndpoints.getUsers.GetUsersClient;
import com.freenow.serviceEndpoints.getUsers.GetUsersResponse;
import com.freenow.serviceEndpoints.getUsers.User;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class ApiTests {

    GetUsersClient getUsersClient;
    GetPostsClient getPostsClient;
    GetCommentsClient getCommentsClient;

    public ApiTests() {
        getUsersClient = new GetUsersClient();
        getPostsClient = new GetPostsClient();
        getCommentsClient = new GetCommentsClient();
    }

    @Test
    public void validateCommentsForPostMadeByAUser() {
        String userName = "Samantha";
        GetUsersResponse getUsersResponse = getUsersClient.getAllUsers();
        Assert.assertEquals(getUsersResponse.getHttpStatusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(!getUsersResponse.getUsers().isEmpty(), "No users returned");
        List<User> requiredUser = getUsersResponse.getUsers().stream().filter(user -> user.getUsername().equals(userName))
                .collect(Collectors.toList());
        Assert.assertTrue(!requiredUser.isEmpty(), "No users present with this name");

        int userId = requiredUser.get(0).getId();

        GetPostsResponse getPostsResponse = getPostsClient.getPostsForAUser(String.valueOf(userId));
        Assert.assertEquals(getPostsResponse.getHttpStatusCode(), HttpStatus.SC_OK);

        for (Post post: getPostsResponse.getPosts()) {
            GetCommentsResponse getCommentsResponse = getCommentsClient.getCommentsForAUser(String.valueOf(post.getId()));
            Assert.assertEquals(getCommentsResponse.getHttpStatusCode(), HttpStatus.SC_OK);
            getCommentsResponse.getComments().forEach(comment -> Assert.assertTrue(EmailIdValidator
                    .validateEmailId(comment.getEmail()), "Email is not valid for comment id" + comment.getId()));
        }
    }
}
