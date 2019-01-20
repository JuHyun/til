package com.simple.servlet;

import com.simple.was.HttpServer;
import com.simple.was.config.ServerConfigLoader;
import com.simple.was.requesthandler.RequestHandlerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class WasMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(WasMain.class);

    public static void main(String[] args) {

        try {
            LOGGER.info("Was Main start!!");

            HttpServer webserver = new HttpServer();
            webserver.setServerConfig(ServerConfigLoader.getConfig(ServerConfigLoader.DEFAULT_CONFI_FILE));

            RequestHandlerManager manager = new RequestHandlerManager();
            manager.putServlet(new Hello());
            manager.putServlet(new SimpleServlet());

            webserver.setRequestHandlerManager(manager);
            webserver.start();

        } catch (IOException e) {
            LOGGER.error("Was Main error occurs!", e);
        }
    }
}
