package com.robinhood.librarysample.data.comment;

import android.support.annotation.NonNull;


import com.robinhood.api.github.api.comment.CommentAPI;
import com.robinhood.api.github.dto.CommentDTO;
import com.robinhood.api.github.model.GithubUser;
import com.robinhood.librarysample.base.util.GithubPreferenceKey;
import com.robinhood.librarysample.base.util.SharedPreferencesService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsRepository implements CommentsDataSource {
    private volatile static CommentsRepository instance = null;

    private GithubUser mGithubUser;

    private CommentAPI mCommentAPI;

    public static CommentsRepository getInstance() {
        if (instance == null) {
            synchronized (CommentsRepository.class) {
                if (instance == null) {
                    instance = new CommentsRepository();
                }
            }
        }

        return instance;
    }

    private CommentsRepository() {
        this(new GithubUser(SharedPreferencesService.getInstance().getPrefStringData(GithubPreferenceKey.PREF_GITHUB_ID_KEY), SharedPreferencesService.getInstance().getPrefStringData(GithubPreferenceKey.PREF_GITHUB_REPOSITORY_KEY)));
    }

    private CommentsRepository(GithubUser githubUser) {
        mGithubUser = githubUser;
        mCommentAPI = new CommentAPI();
    }

    @Override
    public void getComments(int issueNumber, @NonNull LoadCommentsCallback callback) {
        executeCommentsService(issueNumber, callback);
    }

    @Override
    public void createComment(int number, String body, @NonNull final PostCommentCallback callback) {
        if (mCommentAPI != null) {
            mCommentAPI.setIssueNumber(number);
            mCommentAPI.asyncCreateItem(mGithubUser.getUserName(), mGithubUser.getUserRepository(), createBodyMap(body), new Callback<CommentDTO>() {
                @Override
                public void onResponse(Call<CommentDTO> call, Response<CommentDTO> response) {
                    if (response.code() >= 200 && response.code() < 300) {
                        callback.onCommentPosted(Comment.convertModel(response.body()));
                    } else {
                        callback.onCommentPostFailed(response.code(), response.message());
                    }
                }

                @Override
                public void onFailure(Call<CommentDTO> call, Throwable t) {
                    callback.onCommentPostFailed(-1, t.getMessage());
                }
            });
        }
    }


    private void executeCommentsService(int issueNumber, final LoadCommentsCallback loadCommentsCallback) {
        if (mCommentAPI != null) {
            mCommentAPI.setIssueNumber(issueNumber);
            mCommentAPI.asyncRequestItems(mGithubUser.getUserName(), mGithubUser.getUserRepository(), new Callback<List<CommentDTO>>() {
                @Override
                public void onResponse(Call<List<CommentDTO>> call, Response<List<CommentDTO>> response) {
                    Comments comments = new Comments();
                    if (response.code() >= 200 && response.code() < 300) {
                        for (CommentDTO commentDTO : response.body()) {
                            comments.add(Comment.convertModel(commentDTO));
                        }
                        loadCommentsCallback.onCommentsLoaded(comments);
                    } else {
                        loadCommentsCallback.onCommentsFailed(response.code(), response.message());
                    }
                }

                @Override
                public void onFailure(Call<List<CommentDTO>> call, Throwable t) {
                    loadCommentsCallback.onCommentsFailed(-1, t.getMessage());
                }
            });
        }
    }

    private Map<String, String> createBodyMap(String comment) {
        Map<String, String> bodyMap = new HashMap<>();
        bodyMap.put("body", comment);
        return bodyMap;
    }
}
