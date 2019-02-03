package com.simple.was;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParameterParser {

    public static Map<String, String> parse(String path) {
        if (path == null || path.length() == 0) {
            return new HashMap<>();
        }

        String substring = path.substring(path.indexOf("?") + 1);
        String[] splits = substring.split("&");
        Map<String, String> params = new HashMap<>();
        Arrays.stream(splits).forEach(split -> {
            String[] keyValue = split.split("=");
            if (keyValue != null) {
                params.put(keyValue[0], keyValue.length > 1 ? keyValue[1] : null);
            }
        });

        return params;
    }
}
