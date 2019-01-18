package com.simple.was.httpRequest;

import com.simple.was.config.ServerConfig;
import com.simple.was.config.VirtualHost;
import com.simple.was.requesthandler.RequestHandlerManager;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class HttpRequestProcessor {

    private static final String HTTP_ROOT = "webapp";

    private Map<String, String> header;
    private ServerConfig serverConfig;
    private RequestHandlerManager requestHandlerManager;
    private File rootDirectory;
    private String indexFileName = "index.html";

    public HttpRequestProcessor(Map<String, String> header, ServerConfig serverConfig, RequestHandlerManager requestHandlerManager) {
        this.header = header;
        this.serverConfig = serverConfig;
        this.requestHandlerManager = requestHandlerManager;

        setHttpRootDirectory(String.valueOf(header.get("Host")));
    }

    public void process(Socket connection) throws IOException {
        String root = rootDirectory.getPath();
        OutputStream outputStream = new BufferedOutputStream(connection.getOutputStream());
        Writer out = new OutputStreamWriter(outputStream);

        String method = String.valueOf(header.get("Method"));
        String version = "";
        if (method.equals("GET")) {
            String fileName = String.valueOf(header.get("FileName"));
            if (fileName.endsWith("/")) fileName += indexFileName;
            String contentType = URLConnection.getFileNameMap().getContentTypeFor(fileName);

            if (header.get("Version") != null) {
                version = String.valueOf(header.get("Version"));
            }
            File theFile = new File(rootDirectory, fileName.substring(1, fileName.length()));
            if (theFile.canRead()
                    // Don't let clients outside the document root
                    && theFile.getCanonicalPath().startsWith(root)) {
                byte[] theData = Files.readAllBytes(theFile.toPath());
                if (version.startsWith("HTTP/")) { // send a MIME header
                    sendHeader(out, "HTTP/1.0 200 OK", contentType, theData.length);
                }
                // send the file; it may be an image or other binary data
                // so use the underlying output stream
                // instead of the writer
                outputStream.write(theData);
                outputStream.flush();
            } else {
                // can't find the file
                String body = new StringBuilder("<HTML>\r\n")
                        .append("<HEAD><TITLE>File Not Found</TITLE>\r\n")
                        .append("</HEAD>\r\n")
                        .append("<BODY>")
                        .append("<H1>HTTP Error 404: File Not Found</H1>\r\n")
                        .append("</BODY></HTML>\r\n")
                        .toString();
                if (version.startsWith("HTTP/")) { // send a MIME header
                    sendHeader(out, "HTTP/1.0 404 File Not Found", "text/html; charset=utf-8", body.length());
                }
                out.write(body);
                out.flush();
            }
        } else {
            // method does not equal "GET"
            String body = new StringBuilder("<HTML>\r\n").append("<HEAD><TITLE>Not Implemented</TITLE>\r\n").append("</HEAD>\r\n")
                    .append("<BODY>")
                    .append("<H1>HTTP Error 501: Not Implemented</H1>\r\n")
                    .append("</BODY></HTML>\r\n").toString();
            if (version.startsWith("HTTP/")) { // send a MIME header
                sendHeader(out, "HTTP/1.0 501 Not Implemented",
                        "text/html; charset=utf-8", body.length());
            }
            out.write(body);
            out.flush();
        }
    }

    private void setHttpRootDirectory(String host) {
        String httpRoot = getHttpRootDirectoryName(host);
        File file = new File(httpRoot);

        validationFile(file);

        try {
            rootDirectory = file.getCanonicalFile();
        } catch (IOException e) {
            e.printStackTrace();
            rootDirectory = file;
        }
    }

    private String getHttpRootDirectoryName(String host) {
        List<VirtualHost> virtualHosts = this.serverConfig.getVirtualHosts();
        return virtualHosts.stream()
                .filter(virtualHost -> host.startsWith(virtualHost.getServerName()))
                .map(virtualHost -> virtualHost.getDocumentRoot())
                .findFirst()
                .orElse(HTTP_ROOT);
    }

    private void validationFile(File file) {
        if (file.isFile()) {
            throw new IllegalArgumentException("rootDirectory must be a directory, not a file");
        }
    }

    private void sendHeader(Writer out, String responseCode, String contentType, int length)
            throws IOException {
        out.write(responseCode + "\r\n");
        Date now = new Date();
        out.write("Date: " + now + "\r\n");
        out.write("Server: JHTTP 2.0\r\n");
        out.write("Content-length: " + length + "\r\n");
        out.write("Content-type: " + contentType + "\r\n\r\n");
        out.flush();
    }
}
