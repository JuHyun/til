package com.simple.was;

import com.simple.was.config.ServerConfig;
import com.simple.was.httpRequest.HttpRequestProcessor;
import com.simple.was.requesthandler.RequestHandlerManager;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RequestProcessor implements Runnable {

    private final static Logger logger = Logger.getLogger(RequestProcessor.class.getCanonicalName());

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
        // for security checks
        try {
            Map<String, String> header = getHeader();

            HttpRequestProcessor httpRequestProcessor =
                    new HttpRequestProcessor(header, serverConfig, requestHandlerManager);
            httpRequestProcessor.process(connection);

        } catch (IOException ex) {
            logger.log(Level.WARNING, "Error talking to " + connection.getRemoteSocketAddress(), ex);
        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.WARNING, "Error talking to " + connection.getRemoteSocketAddress(), e);
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
