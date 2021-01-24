package com.mzz.gateway.server;
import com.mzz.gateway.route.RouteDefination;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Set;
import java.util.concurrent.Executor;

@Component
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

    public void addRoutes(Set<RouteDefination> routes){
        routes.forEach(p->this.createContext(p.getSourcePath(),new SnakerRouteHandler(p)));
    }
}
