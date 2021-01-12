package com.mzz.snaker.gateway.server;

import com.mzz.snaker.gateway.route.api.DBRouteServiceImpl;
import com.mzz.snaker.gateway.route.api.IRouteService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.List;

public class SnakerRouteHandler implements HttpHandler {

    String url;

    SnakerRouteHandler(String url){
        this.url = url;
    }

    IRouteService routeService = new DBRouteServiceImpl();

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        List<String> list = routeService.getRoute(url).getTargetUrl();
        int randomIndex = (int)(Math.random()*list.size());
        String targetUrl = list.get(randomIndex);

    }
}
