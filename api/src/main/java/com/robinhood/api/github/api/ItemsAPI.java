package com.robinhood.api.github.api;

import java.util.List;

import retrofit2.Callback;

public interface ItemsAPI<T, E extends List<T>> {
    void asyncRequestItems(String owner, String repository, Callback<E> callBack);

    void asyncRequestItem(String owner, String repository, int number, Callback<T> callBack);

    List<T> requestItems(String owner, String repository);

    T requestItem(String owner, String repository, int number);
}
