package com.mzz.snaker.gateway.server;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import sun.net.httpserver.HttpServerImpl;
import sun.net.httpserver.HttpsServerImpl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;

public class SnakerServer extends HttpServer {

    HttpServer httpServer = HttpServer.create();

    public SnakerServer() throws IOException {
    }

    @Override
    public void bind(InetSocketAddress inetSocketAddress, int i) throws IOException {
        httpServer.bind(inetSocketAddress,i);
    }

    @Override
    public void start() {
        httpServer.start();
    }

    @Override
    public void setExecutor(Executor executor) {
        httpServer.setExecutor(executor);

    }

    @Override
    public Executor getExecutor() {
        return httpServer.getExecutor();
    }

    @Override
    public void stop(int i) {
        httpServer.stop(i);
    }

    @Override
    public HttpContext createContext(String s, HttpHandler httpHandler) {
        return httpServer.createContext(s,httpHandler);
    }

    @Override
    public HttpContext createContext(String s) {
        return httpServer.createContext(s);
    }

    @Override
    public void removeContext(String s) throws IllegalArgumentException {
        httpServer.removeContext(s);
    }

    @Override
    public void removeContext(HttpContext httpContext) {
        httpServer.removeContext(httpContext);
    }

    @Override
    public InetSocketAddress getAddress() {
        return httpServer.getAddress();
    }
}
