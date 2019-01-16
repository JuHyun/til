package com.simple.was;

import com.simple.was.config.ServerConfig;
import com.simple.was.config.ServerConfigLoader;
import com.simple.was.config.VirtualHost;
import com.simple.was.requesthandler.RequestHandlerManager;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by cybaek on 15. 5. 22..
 */
public class HttpServer {
    private static final Logger logger = Logger.getLogger(HttpServer.class.getCanonicalName());
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
            logger.info("Accepting connections on port " + server.getLocalPort());
            VirtualHost virtualHost = serverConfig.getVirtualHosts().get(0);
            logger.info("Document Root: " + virtualHost.getDocumentRoot());
            while (true) {
                try {
                    Socket request = server.accept();
                    File file = new File(virtualHost.getDocumentRoot());
//                    Runnable r = new RequestProcessor(file, INDEX_FILE, request);
                    Runnable r = new RequestProcessor(request, serverConfig, requestHandlerManager);
                    pool.submit(r);
                } catch (IOException ex) {
                    logger.log(Level.WARNING, "Error accepting connection", ex);
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
            logger.log(Level.SEVERE, "Server could not start", ex);
        }
    }
}
