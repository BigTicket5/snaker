package com.mzz.gateway.server;

import com.mzz.gateway.route.RouteDefination;
import com.mzz.gateway.service.RemoteCallService;
import com.mzz.gateway.util.SpringContextUtil;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;


import javax.annotation.Resource;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class SnakerRouteHandler implements HttpHandler {

    private RouteDefination routeDefination;

    @Resource(name="${snaker.remote.call.service}")
    private RemoteCallService remoteCallService;

    public SnakerRouteHandler(RouteDefination routeDefination){
        this.routeDefination = routeDefination;
        this.remoteCallService = SpringContextUtil.getBean(RemoteCallService.class);
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        httpExchange.sendResponseHeaders(200, 0);
        OutputStream os = httpExchange.getResponseBody() ;
        List<String> list = routeDefination.getTargetUrl();
        int randomIndex = (int)(Math.random()*list.size());
        String targetUrl = list.get(randomIndex);
        HttpResponse httpResponse = (HttpResponse) remoteCallService.callRemote(targetUrl,httpExchange);
        httpResponse.getEntity().writeTo(os);
        os.close();
    }
}
