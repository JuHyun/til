package com.simple.was;

import com.simple.was.config.ServerConfig;
import com.simple.was.config.ServerConfigLoader;
import com.simple.was.requesthandler.RequestHandlerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cybaek on 15. 5. 22..
 */
public class HttpServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpServer.class);
    private static final int NUM_THREADS = 50;

    private RequestHandlerManager requestHandlerManager;
    private ServerConfig serverConfig;

    public void setServerConfig(ServerConfig serverConfig) {
        this.serverConfig = serverConfig;
    }

    public void setRequestHandlerManager(RequestHandlerManager requestHandlerManager) {
        this.requestHandlerManager = requestHandlerManager;
    }

    public void start() throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);
        try (ServerSocket server = new ServerSocket(serverConfig.getPort())) {
            LOGGER.info("Accepting connections on port " + server.getLocalPort());
            while (true) {
                try {
                    Socket request = server.accept();
                    Runnable r = new RequestProcessor(request, serverConfig, requestHandlerManager);
                    pool.submit(r);
                } catch (IOException ex) {
                    LOGGER.error("Error accepting connection", ex);
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            HttpServer webserver = new HttpServer();
            webserver.setServerConfig(ServerConfigLoader.getConfig(ServerConfigLoader.DEFAULT_CONFI_FILE));
            webserver.start();
        } catch (IOException ex) {
            LOGGER.error("Server could not start", ex);
        }
    }
}
