package com.freenow.serviceEndpoints.getPosts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.freenow.serviceEndpoints.BaseClient;
import com.freenow.utility.request.RequestHandler;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PostsClient extends BaseClient {

    public GetPostsResponse getAllPosts() {
        GetPostsEndpoint getPostsEndpoint = new GetPostsEndpoint();
        Response response = new RequestHandler().processRequest(getPostsEndpoint);
        List<Post> posts = new ArrayList<>();
        try {
            posts = mapper.readValue(response.getBody().asString(), new TypeReference<List<Post>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        GetPostsResponse getPostsResponse = new GetPostsResponse();
        getPostsResponse.setPosts(posts);
        getPostsResponse.setHttpStatusCode(response.getStatusCode());
        return getPostsResponse;
    }

    public GetPostsResponse getPostsForAUser(String userId) {
        GetPostsEndpoint getPostsEndpoint = new GetPostsEndpoint(userId);
        Response response = new RequestHandler().processRequest(getPostsEndpoint);
        List<Post> posts = new ArrayList<>();
        try {
            posts = mapper.readValue(response.getBody().asString(), new TypeReference<List<Post>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        GetPostsResponse getPostsResponse = new GetPostsResponse();
        getPostsResponse.setPosts(posts);
        getPostsResponse.setHttpStatusCode(response.getStatusCode());
        return getPostsResponse;
    }

    public Post createANewPostForAUser(int userId, String title, String body) {
        PostRequestBody postRequestBody = new PostRequestBody(userId, title, body);
        CreatePostEndpoint createPostEndpoint = new CreatePostEndpoint(postRequestBody);
        Response response = new RequestHandler().processRequest(createPostEndpoint);
        Post post = response.as(Post.class);
        post.setHttpStatusCode(response.statusCode());
        return post;
    }

    public Post updateAnExistingPostForAUser(int id, int userId, String title, String body) {
        PostRequestBody postRequestBody = new PostRequestBody(id, userId, title, body);
        UpdatePostEndpoint updatePostEndpoint = new UpdatePostEndpoint(postRequestBody);
        Response response = new RequestHandler().processRequest(updatePostEndpoint);
        Post post = response.as(Post.class);
        post.setHttpStatusCode(response.statusCode());
        return post;
    }
}
