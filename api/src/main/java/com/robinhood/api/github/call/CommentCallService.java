package com.robinhood.api.github.call;


import com.robinhood.api.github.dto.CommentDTO;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface CommentCallService {

    @GET("{fullPath}")
    Call<List<CommentDTO>> comments(@HeaderMap Map<String, String> headers, @Path(value = "fullPath", encoded = true) String fullPath);

    @GET("/repos/{user}/{repository}/issues/{number}/comments")
    Call<List<CommentDTO>> comments(@Path("user") String user, @Path("repository") String repository, @Path("number") int number);

    @GET("/repos/{user}/{repository}/issues/{number}/comments/{id}")
    Call<CommentDTO> comment(@Path("user") String user, @Path("repository") String repository, @Path("number") int number, @Path("id") int id);

    @POST("/repos/{user}/{repository}/issues/{number}/comments")
    Call<CommentDTO> createComment(
            @Path("user") String user,
            @Path("repository") String repository,
            @Path("number") int number,
            @HeaderMap Map<String, String> headers,
            @Body Map<String, String> body);

    @PATCH("/repos/{user}/{repository}/issues/{number}/comments/{id}")
    Call<CommentDTO> updateComment(
            @Path("user") String user,
            @Path("repository") String repository,
            @Path("number") int number,
            @Path("id") int id,
            @HeaderMap Map<String, String> headers,
            @Body Map<String, String> body);

    @DELETE("/repos/{user}/{repository}/issues/{number}/comments/{id}")
    Call deleteComment(
            @Path("user") String user,
            @Path("repository") String repository,
            @Path("number") int number,
            @Path("id") int id,
            @HeaderMap Map<String, String> headers);
}
