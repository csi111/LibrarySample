package com.robinhood.api.github.model;

public class GithubConfiguration {
    private volatile static GithubConfiguration instance = null;

    private String mAccessToken;

    private GithubConfiguration() {
    }

    public static GithubConfiguration getInstance() {
        if (instance == null) {
            synchronized (GithubConfiguration.class) {
                if (instance == null) {
                    instance = new GithubConfiguration();
                }
            }
        }
        return instance;
    }

    public void setAccessToken(String accessToken) {
        this.mAccessToken = accessToken;
    }

    @Header("Authorization")
    public String getAccessToken() {
        return mAccessToken;
    }
}
