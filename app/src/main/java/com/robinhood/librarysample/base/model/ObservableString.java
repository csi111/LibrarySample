package com.robinhood.librarysample.base.model;

import android.databinding.BaseObservable;
import android.databinding.BindingConversion;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ObservableString extends BaseObservable implements Parcelable, Serializable {


    private String mValue;

    public ObservableString(String mValue) {
        this.mValue = mValue;
    }

    public ObservableString() {
    }


    public String get() {
        return mValue;
    }

    public void set(String value) {
        this.mValue = value;
        notifyChange();
    }

    protected ObservableString(Parcel in) {
    }


    public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }

    public boolean isEmpty() {
        return mValue == null || mValue.isEmpty();
    }

    @BindingConversion
    public static String convertToString(ObservableString s) {
        return s.get();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ObservableString> CREATOR = new Creator<ObservableString>() {
        @Override
        public ObservableString createFromParcel(Parcel in) {
            return new ObservableString(in);
        }

        @Override
        public ObservableString[] newArray(int size) {
            return new ObservableString[size];
        }
    };
}
