package com.robinhood.api.github;


import com.robinhood.api.github.model.Header;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HeaderMatcher {
    public static Map<String, String> pickHeaderListOut(Object obj) {
        Map<String, String> headerMap = new HashMap<>();
        Method[] methods = obj.getClass().getMethods();
        for (Method method : methods) {
            Header header = method.getAnnotation(Header.class);

            if (header == null) {
                continue;
            }
            if (!method.getReturnType().isPrimitive() && !(method.getReturnType().isAssignableFrom(String.class))) {
                continue;
            }

            String key = header.value();
            Object value = getValue(method, obj);

            if (value != null) {
                headerMap.put(key, String.valueOf(value));
            }
        }
        return headerMap;
    }

    private static Object getValue(Method method, Object target) {
        Object value = null;
        try {
            value = method.invoke(target);
        } catch (Exception e) {
            e.printStackTrace();
            value = null;
        }
        return value;
    }
}
