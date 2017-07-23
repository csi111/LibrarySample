package com.robinhood.api.github.api;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class GithubPaginationAPI<T, E> extends GithubAPI<T> implements PaginationAPI<E>, ItemsAPI<E, List<E>>, Callback<List<E>> {
    private final String KEY_HEADER_PAGE_URL = "Link";
    private final String PATTERN_NEXT_PAGE = "<(.+)>; rel=\"next\"";

    private Callback mPaginationCallback;
    private String mNextPageUrl;

    public GithubPaginationAPI(Class clazz) {
        super(clazz);
    }

    protected void setNextPageUrl(String nextPageUrl) {
        this.mNextPageUrl = nextPageUrl;
    }

    public String getNextPageUrl() {
        return mNextPageUrl;
    }


    @Override
    public void onResponse(Call<List<E>> call, Response<List<E>> response) {
        matcherNextPage(response.headers());
        mPaginationCallback.onResponse(call, response);
    }

    @Override
    public void asyncRequestNextPage(Callback<List<E>> callBack) {
        mPaginationCallback = callBack;
    }

    @Override
    public void asyncRequestItems(String owner, String repository, Callback<List<E>> callBack) {
        mPaginationCallback = callBack;
    }

    @Override
    public void onFailure(Call<List<E>> call, Throwable t) {
        mPaginationCallback.onFailure(call, t);
    }

    @Override
    public void matcherNextPage(Headers headers) {
        String linkUrl = headers.get(KEY_HEADER_PAGE_URL);
        setNextPageUrl(patternMatch(linkUrl));
    }

    private String patternMatch(String input) {
        if (input != null && input.length() > 0) {
            Pattern pattern = Pattern.compile(PATTERN_NEXT_PAGE);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find() && matcher.groupCount() > 0) {
                return matcher.group(1);
            }
        }
        return "";
    }
}
