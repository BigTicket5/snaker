package com.mzz.gateway.server;

import com.mzz.gateway.route.api.DBRouteServiceImpl;
import com.mzz.gateway.route.api.IRouteService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class SnakerRouteHandler implements HttpHandler {

    private String url;

    int timeout = 5;
    RequestConfig config = RequestConfig.custom()
            .setConnectTimeout(timeout * 1000)
            .setConnectionRequestTimeout(timeout * 1000)
            .setSocketTimeout(timeout * 1000).build();
    HttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
    public SnakerRouteHandler(String url){
        this.url = url;
    }

    IRouteService routeService = new DBRouteServiceImpl();

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        List<String> list = routeService.getRoute(url).getTargetUrl();
        int randomIndex = (int)(Math.random()*list.size());
        String targetUrl = list.get(randomIndex);
        HttpUriRequest getRequest = new HttpGet(targetUrl);
        HttpResponse httpResponse = httpClient.execute(getRequest);
        httpExchange.sendResponseHeaders(200, 0);
        OutputStream os = httpExchange.getResponseBody() ;
        httpResponse.getEntity().writeTo(os);
        os.close();
    }
}
