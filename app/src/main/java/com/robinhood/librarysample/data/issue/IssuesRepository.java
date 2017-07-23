package com.robinhood.librarysample.data.issue;

import android.support.annotation.NonNull;


import com.robinhood.api.github.api.issue.IssueAPI;
import com.robinhood.api.github.dto.IssueDTO;
import com.robinhood.api.github.model.GithubUser;
import com.robinhood.librarysample.base.util.GithubPreferenceKey;
import com.robinhood.librarysample.base.util.SharedPreferencesService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class IssuesRepository implements IssuesDataSource {
    private static IssuesRepository instance = null;

    private IssueAPI issueAPI;

    private Issues mIssues;

    private GithubUser githubUser;

    private IssuesRepository() {
        this(new GithubUser(SharedPreferencesService.getInstance().getPrefStringData(GithubPreferenceKey.PREF_GITHUB_ID_KEY), SharedPreferencesService.getInstance().getPrefStringData(GithubPreferenceKey.PREF_GITHUB_REPOSITORY_KEY)));
    }

    private IssuesRepository(GithubUser githubUser) {
        this.githubUser = githubUser;
        issueAPI = new IssueAPI();

    }

    public static IssuesRepository getInstance() {
        if (instance == null) {
            instance = new IssuesRepository();
        }
        return instance;
    }

    public static IssuesRepository getInstance(GithubUser gitHubUser) {
        if (instance == null) {
            instance = new IssuesRepository(gitHubUser);
        }
        return instance;
    }

    @Override
    public void fetchIssues(@NonNull LoadIssuesCallback callback) {
        checkNotNull(callback);
        executeIssuesService(callback);
    }

    @Override
    public void fetchIssues() {

    }

    @Override
    public Issues getIssues() {
        return mIssues;
    }

    @Override
    public void fetchIssue(int issueNumber, LoadIssueCallback callback) {
        checkNotNull(callback);

        if (issueNumber < 0) {
            callback.onIssueFailed(-1, "doesn't set issueNumber");
            return;
        }

        executeIssueService(issueNumber, callback);
    }

    @Override
    public void fetchIssue(int issueNumber) {
        executeIssueService(issueNumber, null);
    }

    @Override
    public Issue getIssue(int issueNumber) {
        return null;
    }

    private void refreshCache(Issues issues) {
        if (mIssues == null) {
            mIssues = new Issues();
        }
        mIssues.clear();
        for (Issue issue : issues) {
            mIssues.add(issue);
        }
    }

    private void executeIssuesService(final LoadIssuesCallback loadIssuesCallback) {
        issueAPI.asyncRequestItems(githubUser.getUserName(), githubUser.getUserRepository(), new Callback<List<IssueDTO>>() {
            @Override
            public void onResponse(Call<List<IssueDTO>> call, Response<List<IssueDTO>> response) {
                Issues issues = new Issues();

                if (response.code() >= 200 && response.code() < 300) {
                    List<IssueDTO> issuesDTO = response.body();
                    for (IssueDTO issueDTO : issuesDTO) {
                        issues.add(Issue.convertModel(issueDTO));
                    }
                    refreshCache(issues);
                    if (loadIssuesCallback != null) {
                        loadIssuesCallback.onIssuesLoaded(issues);
                    }
                } else {
                    if (loadIssuesCallback != null) {
                        loadIssuesCallback.onIssuesFailed(response.code(), response.message());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<IssueDTO>> call, Throwable t) {
                loadIssuesCallback.onIssuesFailed(-1, t.getMessage());
            }
        });
    }

    private void executeIssueService(int number, final LoadIssueCallback loadIssuesCallback) {
        issueAPI.asyncRequestItem(githubUser.getUserName(), githubUser.getUserRepository(), number, new Callback<IssueDTO>() {
            @Override
            public void onResponse(Call<IssueDTO> call, Response<IssueDTO> response) {
                if (response.code() >= 200 && response.code() < 300) {
                    Issue issue = Issue.convertModel(response.body());
                    loadIssuesCallback.onIssueLoaded(issue);
                } else {
                    loadIssuesCallback.onIssueFailed(response.code(), response.message());
                }
            }

            @Override
            public void onFailure(Call<IssueDTO> call, Throwable t) {
                loadIssuesCallback.onIssueFailed(-1, t.getMessage());
            }
        });
    }
}

