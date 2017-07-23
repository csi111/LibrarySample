package com.robinhood.api.github.api.issue;


import com.robinhood.api.github.api.GithubPaginationAPI;
import com.robinhood.api.github.call.IssueCallService;
import com.robinhood.api.github.dto.IssueDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class IssueAPI extends GithubPaginationAPI<IssueCallService, IssueDTO> {

    private IssueCallService callService;

    public IssueAPI() {
        super(IssueCallService.class);
        callService = createCallService();

    }

    @Override
    public void asyncRequestNextPage(Callback<List<IssueDTO>> callBack) {
        super.asyncRequestNextPage(callBack);
        callService.issues(getHeaderMap(), getNextPageUrl()).enqueue(this);
    }

    @Override
    public List<IssueDTO> requestNextPage() {
        List<IssueDTO> responseBody = new ArrayList<>();
        try {
            Response<List<IssueDTO>> response = callService.issues(getHeaderMap(), getNextPageUrl()).execute();
            responseBody.addAll(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseBody;
    }

    @Override
    public void asyncRequestItems(String owner, String repository, Callback<List<IssueDTO>> callBack) {
        super.asyncRequestItems(owner, repository, callBack);
        callService.issues(owner, repository).enqueue(this);
    }

    @Override
    public void asyncRequestItem(String owner, String repository, int number, Callback<IssueDTO> callBack) {
        callService.issue(owner, repository, number).enqueue(callBack);
    }

    @Override
    public List<IssueDTO> requestItems(String owner, String repository) {
        List<IssueDTO> responseBody = new ArrayList<>();
        try {
            Response<List<IssueDTO>> response = callService.issues(owner, repository).execute();
            matcherNextPage(response.headers());
            responseBody.addAll(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseBody;
    }

    @Override
    public IssueDTO requestItem(String owner, String repository, int number) {
        IssueDTO issueDTO = null;
        try {
            Response<IssueDTO> response = callService.issue(owner, repository, number).execute();
            issueDTO = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return issueDTO;
    }

}
