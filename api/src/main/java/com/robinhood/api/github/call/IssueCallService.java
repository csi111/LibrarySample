package com.robinhood.api.github.call;


import com.robinhood.api.github.dto.IssueDTO;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IssueCallService {

    @GET("{fullPath}")
    Call<List<IssueDTO>> issues(@HeaderMap Map<String, String> headers, @Path(value = "fullPath", encoded = true) String fullPath);

    @GET("/repos/{owner}/{repository}/issues")
    Call<List<IssueDTO>> issues(@Path("owner") String owner, @Path("repository") String repository);

    @GET("/orgs/{orgs}/issues")
    Call<List<IssueDTO>> issues(@Path("orgs") String organization);

    @GET("/repos/{owner}/{repository}/issues/{number}")
    Call<IssueDTO> issue(@Path("owner") String owner, @Path("repository") String repository, @Path("number") int number);

    @POST("/repos/{owner}/{repository}/issues")
    Call<IssueDTO> postIssue(@Path("owner") String owner, @Path("repository") String repository, @Body IssueDTO issueDTO);
}
