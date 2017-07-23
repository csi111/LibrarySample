package com.robinhood.api.github.api;

import java.util.List;

import okhttp3.Headers;
import retrofit2.Callback;

public interface PaginationAPI<T> {

    void asyncRequestNextPage(Callback<List<T>> callBack);

    List<T> requestNextPage();

    void matcherNextPage(Headers headers);

}
