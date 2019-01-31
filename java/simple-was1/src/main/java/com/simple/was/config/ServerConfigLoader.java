package com.simple.was.config;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ServerConfigLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerConfigLoader.class);

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
        StringBuilder stringBuilder = new StringBuilder();
        try (InputStream resourceAsStream = classLoader.getResourceAsStream(configFileName)) {
            if (resourceAsStream == null) {
                LOGGER.error("There is no " + configFileName + " file.");
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
            String nextLine;

            while (true) {
                try {
                    if ((nextLine = bufferedReader.readLine()) == null) break;
                    if (nextLine.length() == 0) break;
                    stringBuilder.append(nextLine);
                } catch (IOException e) {
                    e.printStackTrace();
                    LOGGER.error("Config File Read Error. ", e);
                }
            }
        } catch (IOException e) {
            LOGGER.error("file read error", e);
        }

        return stringBuilder.toString();
    }
}
