package com.robinhood.librarysample.base.util;

public enum PreferenceKey {
    GITHUB_ACCESS_TOKEN("GITHUB_ACCESS_TOKEN", String.class),
    GITHUB_ID("GITHUB_ID", String.class),
    GITHUB_REPOSITORY("GITHUB_REPOSITORY", String.class);

    String key;
    Class valueType;

    PreferenceKey(String key, Class valueType) {
        this.key = key;
        this.valueType = valueType;
    }

    public String getKey() {
        return key;
    }

    public Class getValueType() {
        return valueType;
    }
}
