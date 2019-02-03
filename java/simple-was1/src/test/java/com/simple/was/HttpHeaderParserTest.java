package com.simple.was;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpHeaderParserTest {

    public static final String REGEX = "([a-z0-9_-]+=[a-z0-9_-]+)";

    @Test
    public void parseParamters() {
        parseParams("/?name=pikanpie&age=30&zip_code=123456&apt=&sing=revelent");
        System.out.println("================");
        parseParams("/users/1234/houses/?name=pikanpie&age=30&zip_code=123456&apt=&sing=revelent");
    }

    private void parseParams(String path) {
        String substring = path.substring(path.indexOf("?") + 1);
        String[] splits = substring.split("&");
        Map<String, String> params = new HashMap<>();
        Arrays.stream(splits).forEach(split -> {
            String[] keyValue = split.split("=");
            if (keyValue != null) {
                params.put(keyValue[0], keyValue.length > 1 ? keyValue[1] : null);
            }
        });

        params.keySet().stream().forEach(key -> System.out.println(key + ":" + params.get(key)));
    }
}
