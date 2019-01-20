package com.simple.was;

import com.simple.was.config.ServerConfig;
import com.simple.was.httpRequest.HttpRequestProcessor;
import com.simple.was.requesthandler.RequestHandlerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;

public class RequestProcessor implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestProcessor.class);

    private Socket connection;
    private ServerConfig serverConfig;
    private RequestHandlerManager requestHandlerManager;

    public RequestProcessor(Socket connection, ServerConfig serverConfig, RequestHandlerManager requestHandlerManager) {
        this.connection = connection;
        this.serverConfig = serverConfig;
        this.requestHandlerManager = requestHandlerManager;
    }

    @Override
    public void run() {
        try {
            Map<String, String> header = getHeader();

            HttpRequestProcessor httpRequestProcessor = new HttpRequestProcessor(header, serverConfig, requestHandlerManager);
            httpRequestProcessor.process(connection);

        } catch (IOException ex) {
            LOGGER.error("Error talking to " + connection.getRemoteSocketAddress(), ex);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Error talking to " + connection.getRemoteSocketAddress(), e);
        } finally {
            try {
                connection.close();
            } catch (IOException ex) {
            }
        }
    }

    private Map<String, String> getHeader() throws Exception {
        HttpHeaderParser parser = new HttpHeaderParser();
        return parser.parse(connection.getInputStream());
    }
}
