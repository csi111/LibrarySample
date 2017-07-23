package com.robinhood.librarysample.base.util;

import android.text.TextUtils;

public class StringUtil {
    /**
     * 스트링값 공백및 널값 검사
     *
     * @param data Check string data
     * @return If data is null or length 0, return false.
     */
    public static boolean isNullOrEmpty(String data) {
        return TextUtils.isEmpty(data);
    }

    /**
     * 스트링검사후 널값이면 변환하고 없으면 그대로 반환
     *
     * @param data Check string data
     * @param replace If data is null, for returning data
     * @return If data is null or length 0, return replace string.
     */
    public static String getReplaceStringIfNullOrEmpty(String data, String replace) {
        return StringUtil.isNullOrEmpty(data) ? replace : data;
    }

    public static String NullOrEmptyToTrimString(String data) {

        if (!isNullOrEmpty(data))
            data = data.trim();
        return data;
    }
}
