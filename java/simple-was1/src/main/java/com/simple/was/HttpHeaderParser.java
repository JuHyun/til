package com.simple.was;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class HttpHeaderParser {

    public Map<String, Object> parse(InputStream inputStream) throws Exception {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        Reader reader = new InputStreamReader(bufferedInputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(reader);

        String nextLine;
        int lineCount = 0;

        Map<String, Object> headerMap = new HashMap<>();
        while ((nextLine = bufferedReader.readLine()) != null) {
            if (nextLine == null || nextLine.length() == 0) break;

            if (isFirstLine(lineCount)) {
                String[] tokens = nextLine.split("\\s+");
                String version = "";

                headerMap.put("Method", tokens[0]);
                headerMap.put("FileName", parseFileName(tokens[1]));
                headerMap.put("Parameters", ParameterParser.parse(tokens[1]));

                if (tokens.length > 2) {
                    version = tokens[2];
                }

                headerMap.put("Version", version);
                lineCount++;
            } else {
                String[] tokens = parseHeader(nextLine);
                headerMap.put(tokens[0], tokens[1]);
            }
        }

        return headerMap;
    }

    private static String[] parseHeader(String headerLine) throws Exception {
        int colonIndex = headerLine.indexOf(':');
        if (colonIndex == -1 || colonIndex == 0 || colonIndex == headerLine.length() - 1) {
            throw new Exception(String.format("Improperly formatted header: %s", headerLine));
        }
        return new String[]{headerLine.substring(0, colonIndex), headerLine.substring(colonIndex + 1, headerLine.length()).trim()};
    }

    private String parseFileName(String value) {
        int index = value.indexOf("?");
        return index > -1 ? value.substring(0, index) : value;
    }

    private boolean isFirstLine(int count) {
        if (count == 0) {
            return true;
        }
        return false;
    }
}
