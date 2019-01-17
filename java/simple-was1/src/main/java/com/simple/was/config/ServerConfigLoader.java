package com.simple.was.config;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Stream;

public class ServerConfigLoader {

    public static final String DEFAULT_CONFI_FILE = "serverConfig.json";

    private static ServerConfig serverConfig;

    public static ServerConfig getConfig(String configFileName) {
        String jsonStringConfig = readConfigFile(configFileName);
        if (jsonStringConfig == null || jsonStringConfig.length() == 0) {
//            setDefaultConfig();
        }
        convertJsonStringToObject(jsonStringConfig);

        validatePort();

        return serverConfig;
    }

    private static void validatePort() {
        if (!isValidPort(serverConfig.getPort())) {
            serverConfig.setPort(80);
        }
    }

    private static boolean isValidPort(int port) {
        return port >= 0 && port <= 65535;
    }

    private static void convertJsonStringToObject(String jsonStringConfig) {
        Gson gson = new Gson();
        serverConfig = gson.fromJson(jsonStringConfig, ServerConfig.class);
    }

    private static String readConfigFile(String configFileName) {
        ClassLoader classLoader = ServerConfigLoader.class.getClassLoader();
        File file = new File(classLoader.getResource(configFileName).getFile());
        Stream<String> lines = null;
        try {
            lines = Files.lines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        lines.forEach(line -> {
            stringBuilder.append(line);
        });

        return stringBuilder.toString();
    }
}
