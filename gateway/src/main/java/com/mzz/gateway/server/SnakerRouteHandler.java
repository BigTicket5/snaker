package com.mzz.gateway.server;

import com.mzz.gateway.client.SnakerClient;
import com.mzz.gateway.route.RouteDefination;
import com.mzz.gateway.route.api.DBRouteServiceImpl;
import com.mzz.gateway.route.api.IRouteService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;


import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class SnakerRouteHandler implements HttpHandler {

    private RouteDefination routeDefination;

    public SnakerRouteHandler(RouteDefination routeDefination){
        this.routeDefination = routeDefination;
    }



    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        List<String> list = routeDefination.getTargetUrl();
        int randomIndex = (int)(Math.random()*list.size());
        String targetUrl = list.get(randomIndex);
        HttpUriRequest getRequest = new HttpGet(targetUrl);
        HttpResponse httpResponse = SnakerClient.initClient().execute(getRequest);
        httpExchange.sendResponseHeaders(200, 0);
        OutputStream os = httpExchange.getResponseBody() ;
        httpResponse.getEntity().writeTo(os);
        os.close();
    }
}
