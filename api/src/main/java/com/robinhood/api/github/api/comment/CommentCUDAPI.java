package com.robinhood.api.github.api.comment;

import java.util.Map;

import retrofit2.Callback;

public interface CommentCUDAPI<T> {
    void asyncCreateItem(String owner, String repository, Map<String, String> body, Callback<T> callBack);

    void asyncUpdateItem(String owner, String repository, int number, Map<String, String> body, Callback<T> callBack);

    void asyncDeleteItem(String owner, String repository, int number, Callback<T> callBack);

    T createItem(String owner, String repository, Map<String, String> body);

    T updateItem(String owner, String repository, int number, Map<String, String> body);

    String deleteItem(String owner, String repository, int number);

}