package com.simple.was.requesthandler;

import com.simple.was.config.VirtualHost;
import com.simple.was.html.ErrorHtml;
import com.simple.was.html.HtmlDrawFactory;
import com.simple.was.http.HttpStatus;
import com.simple.was.httpRequest.BasicHttpRequest;
import com.simple.was.httpRequest.BasicHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;

public class DefaultHandler implements BasicHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHandler.class);

    private static final String INDEX_HTML = "index.html";

    private File rootDirectory;
    private VirtualHost virtualHost;

    public DefaultHandler(VirtualHost virtualHost) {
        this.virtualHost = virtualHost;
        setHttpRootDirectory();
    }

    @Override
    public void service(BasicHttpRequest req, BasicHttpResponse response) {
        String method = req.getMethod();

        LOGGER.debug(virtualHost.toString());

        if (method.equals("GET")) {
            try {
                doGet(req, response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            doNotGet(req, response);

        }
    }

    private void doGet(BasicHttpRequest request, BasicHttpResponse response) throws IOException {
        String version = request.getVersion();
        String fileName = request.getRequestFile();
        String indexFileName = INDEX_HTML;

        if (fileName == null || fileName.length() == 0) {
            fileName += indexFileName;
        }


        if (isInvalidFileName(fileName)) {
            String contentType = URLConnection.getFileNameMap().getContentTypeFor(virtualHost.getForbidden());
            File theFile = new File(rootDirectory, virtualHost.getForbidden());

            if (processStream("HTTP/1.0 403 Forbidden", response, version, contentType, theFile))
                return;
        }

        String contentType = URLConnection.getFileNameMap().getContentTypeFor(fileName);
        File theFile = new File(rootDirectory, fileName);
        if (processStream("HTTP/1.0 200 OK", response, version, contentType, theFile)) {
            return;
        }

        // can't find the file
        contentType = URLConnection.getFileNameMap().getContentTypeFor(virtualHost.getNotFound());
        theFile = new File(rootDirectory, virtualHost.getNotFound());
        processStream("HTTP/1.0 404 File Not Found", response, version, contentType, theFile);
    }

    private boolean processStream(String httpCode, BasicHttpResponse response, String version,
                                  String contentType, File theFile) throws IOException {
        if (theFile.canRead()
                // Don't let clients outside the document root
                && theFile.getCanonicalPath().startsWith(rootDirectory.getPath())) {
            byte[] theData = Files.readAllBytes(theFile.toPath());
            if (version.startsWith("HTTP/")) { // send a MIME header
                response.sendHeader(httpCode, contentType, theData.length);
            }
            // send the file; it may be an image or other binary data
            // so use the underlying output stream
            // instead of the writer
            response.writeBody(theData);

            return true;
        }
        return false;
    }

    private void doNotGet(BasicHttpRequest request, BasicHttpResponse response) {
        // method does not equal "GET"
        String version = request.getVersion();
        if (version.startsWith("HTTP/")) { // send a MIME header
            try {
                ErrorHtml errorHtml = HtmlDrawFactory.createHtml(HttpStatus.NOT_IMPLEMENTED.getStatusCode());
                String body = errorHtml.load();
                response.sendHeader("HTTP/1.0 501 Not Implemented", "text/html; charset=utf-8", body.length());
                response.writeBody(body);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isInvalidFileName(String fileName) {
        return fileName.startsWith("../") || fileName.endsWith(".exe");
    }

    private void setHttpRootDirectory() {
        String httpRoot = virtualHost.getDocumentRoot();
        File file = new File(httpRoot);

        validationFile(file);

        try {
            rootDirectory = file.getCanonicalFile();
        } catch (IOException e) {
            e.printStackTrace();
            rootDirectory = file;
        }
    }

    private void validationFile(File file) {
        if (file.isFile()) {
            throw new IllegalArgumentException("rootDirectory must be a directory, not a file");
        }
    }
}
