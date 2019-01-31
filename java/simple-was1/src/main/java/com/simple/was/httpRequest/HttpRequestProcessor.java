package com.simple.was.httpRequest;

import com.simple.was.config.ServerConfig;
import com.simple.was.config.VirtualHost;
import com.simple.was.http.HttpConstant;
import com.simple.was.requesthandler.DefaultHandler;
import com.simple.was.requesthandler.RequestHandlerManager;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpRequestProcessor {

    private static final String HTTP_ROOT = "webapp";

    private Map<String, String> header;
    private ServerConfig serverConfig;
    private RequestHandlerManager requestHandlerManager;
    private File rootDirectory;
    private VirtualHost virtualHost;

    public HttpRequestProcessor() {};

    public HttpRequestProcessor(Map<String, String> header, ServerConfig serverConfig, RequestHandlerManager requestHandlerManager) {
        this.header = header;
        this.serverConfig = serverConfig;
        this.requestHandlerManager = requestHandlerManager;

        setVirtualHost(String.valueOf(header.get(HttpConstant.HOST)));
    }

    public void process(Socket connection) throws IOException {
        OutputStream outputStream = new BufferedOutputStream(connection.getOutputStream());
        Writer out = new OutputStreamWriter(outputStream);

        String method = String.valueOf(header.get(HttpConstant.METHOD));
        String fileName = String.valueOf(header.get(HttpConstant.FILE_NAME));
        String version = header.get(HttpConstant.VERSION);
        String requestUrl = header.get(HttpConstant.HOST);

        SimpleHttpRequest request = new SimpleHttpRequest(method, requestUrl, version);
        if (fileName != null) {
            request.setRequestFile(fileName.substring(1));
        }

        SimpleHttpResponse response = new SimpleHttpResponse(out, outputStream);

        if (requestHandlerManager == null || requestHandlerManager.getServletMap().get(request.getRequestFile()) == null) {
            DefaultHandler defaultSevlet = new DefaultHandler(virtualHost);
            defaultSevlet.service(request, response);
        } else {
            requestHandlerManager.getServletMap().get(request.getRequestFile()).service(request, response);
        }
    }

    private void setVirtualHost(String host) {
        List<VirtualHost> virtualHosts = this.serverConfig.getVirtualHosts();
        VirtualHost serverInfo = virtualHosts.stream()
                .filter(virtualHost -> host(host).equals(virtualHost.getServerName()))
                .findFirst()
                .orElse(VirtualHost.create("a.com", "webapp", "403.html", "404.html", "500.html"));
        this.virtualHost = serverInfo;
    }

    public String host(String host) {
        Pattern pattern = Pattern.compile("^[a-z0-9.-]+");
        Matcher matcher = pattern.matcher(host);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }
}
