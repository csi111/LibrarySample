package com.robinhood.librarysample.base.util;

import android.os.Bundle;
import android.os.Parcelable;

import java.io.Serializable;

public class BundleBuilder {
    private Bundle bundle;

    public BundleBuilder() {
        this.bundle = new Bundle();
    }

    public static BundleBuilder create() {
        return new BundleBuilder();
    }

    public BundleBuilder with(Serializable value) {
        if (value != null) {
            bundle.putSerializable(value.getClass().getName(), value);
        }
        return this;
    }

    public BundleBuilder with(String key, String value) {
        bundle.putSerializable(key, value);
        return this;
    }

    public BundleBuilder with(String key, Serializable value) {
        bundle.putSerializable(key, value);
        return this;
    }

    public BundleBuilder with(String key, Parcelable value) {
        if (value != null) {
            bundle.putParcelable(key, value);
        }
        return this;
    }

    public BundleBuilder with(Parcelable value) {
        with(value.getClass().getName(), value);
        return this;
    }

    public Bundle build() {
        return bundle;
    }
}
