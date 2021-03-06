package com.freenow.serviceEndpoints.posts.clients;

import com.fasterxml.jackson.core.type.TypeReference;
import com.freenow.serviceEndpoints.base.BaseClient;
import com.freenow.serviceEndpoints.posts.response.GetPostsResponse;
import com.freenow.serviceEndpoints.posts.response.Post;
import com.freenow.serviceEndpoints.posts.request.CreatePostEndpoint;
import com.freenow.serviceEndpoints.posts.request.PostRequestBody;
import com.freenow.serviceEndpoints.posts.request.PostsEndpoint;
import com.freenow.serviceEndpoints.posts.request.UpdatePostEndpoint;
import com.freenow.utility.request.HttpMethod;
import com.freenow.utility.request.RequestHandler;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PostsClient extends BaseClient {

    public GetPostsResponse getAllPosts() {
        PostsEndpoint postsEndpoint = new PostsEndpoint(HttpMethod.GET);
        Response response = new RequestHandler().processRequest(postsEndpoint);
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
        PostsEndpoint postsEndpoint = new PostsEndpoint(userId, HttpMethod.GET);
        Response response = new RequestHandler().processRequest(postsEndpoint);
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

    public int getHttpStatusForDeletingAnExistingPost(int postId) {
        PostsEndpoint postsEndpoint = new PostsEndpoint(postId, HttpMethod.DELETE);
        Response response = new RequestHandler().processRequest(postsEndpoint);
        return response.getStatusCode();
    }

    public int getHttpStatusForFetchingPostsWithPostIdNestedRoute(int postId) {
        PostsEndpoint postsEndpoint = new PostsEndpoint(postId, HttpMethod.GET);
        Response response = new RequestHandler().processRequest(postsEndpoint);
        return response.getStatusCode();
    }
}
