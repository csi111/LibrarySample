package com.robinhood.api.github.api.comment;


import com.robinhood.api.github.api.GithubPaginationAPI;
import com.robinhood.api.github.call.CommentCallService;
import com.robinhood.api.github.dto.CommentDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Callback;
import retrofit2.Response;

public class CommentAPI extends GithubPaginationAPI<CommentCallService, CommentDTO> implements CommentCUDAPI<CommentDTO> {

    private CommentCallService mCallService;

    private int mIssueNumber;

    public CommentAPI() {
        this(-1);
    }

    public CommentAPI(int issueNumber) {
        super(CommentCallService.class);
        mCallService = createCallService();
        mIssueNumber = issueNumber;
    }

    @Override
    public void asyncRequestNextPage(Callback<List<CommentDTO>> callBack) {
        super.asyncRequestNextPage(callBack);
        mCallService.comments(getHeaderMap(), getNextPageUrl()).enqueue(this);
    }

    @Override
    public void asyncRequestItems(String owner, String repository, Callback<List<CommentDTO>> callBack) {
        super.asyncRequestItems(owner, repository, callBack);
        mCallService.comments(owner, repository, mIssueNumber).enqueue(this);
    }

    @Override
    public void asyncRequestItem(String owner, String repository, int number, Callback<CommentDTO> callBack) {
        mCallService.comment(owner, repository, mIssueNumber, number).enqueue(callBack);
    }

    @Override
    public List<CommentDTO> requestItems(String owner, String repository) {
        List<CommentDTO> responseBody = new ArrayList<>();
        try {
            Response<List<CommentDTO>> response = mCallService.comments(owner, repository, mIssueNumber).execute();
            matcherNextPage(response.headers());
            responseBody.addAll(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseBody;
    }

    @Override
    public CommentDTO requestItem(String owner, String repository, int number) {
        CommentDTO commentDTO = null;
        try {
            Response<CommentDTO> response = mCallService.comment(owner, repository, mIssueNumber, number).execute();
            commentDTO = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commentDTO;
    }

    @Override
    public List<CommentDTO> requestNextPage() {
        List<CommentDTO> responseBody = new ArrayList<>();
        try {
            Response<List<CommentDTO>> response = mCallService.comments(getHeaderMap(), getNextPageUrl()).execute();
            responseBody.addAll(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseBody;
    }

    @Override
    public void asyncCreateItem(String owner, String repository, Map<String, String> body, Callback<CommentDTO> callBack) {
        mCallService.createComment(owner, repository, mIssueNumber, getHeaderMap(), body).enqueue(callBack);
    }

    @Override
    public void asyncUpdateItem(String owner, String repository, int number, Map<String, String> body, Callback<CommentDTO> callBack) {
        mCallService.updateComment(owner, repository, mIssueNumber, number, getHeaderMap(), body).enqueue(callBack);
    }

    @Override
    public void asyncDeleteItem(String owner, String repository, int number, Callback<CommentDTO> callBack) {
        mCallService.deleteComment(owner, repository, mIssueNumber, number, getHeaderMap()).enqueue(callBack);
    }

    @Override
    public CommentDTO createItem(String owner, String repository, Map<String, String> body) {
        CommentDTO commentDTO = null;
        try {
            Response<CommentDTO> response = mCallService.createComment(owner, repository, mIssueNumber, getHeaderMap(), body).execute();
            commentDTO = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commentDTO;
    }

    @Override
    public CommentDTO updateItem(String owner, String repository, int number, Map<String, String> body) {
        CommentDTO commentDTO = null;
        try {
            Response<CommentDTO> response = mCallService.updateComment(owner, repository, mIssueNumber, number, getHeaderMap(), body).execute();
            commentDTO = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commentDTO;
    }

    @Override
    public String deleteItem(String owner, String repository, int number) {
        try {
            Response<String> response = mCallService.deleteComment(owner, repository, mIssueNumber, number, getHeaderMap()).execute();
            return response.message();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setIssueNumber(int issueNumber) {
        mIssueNumber = issueNumber;
    }
}
