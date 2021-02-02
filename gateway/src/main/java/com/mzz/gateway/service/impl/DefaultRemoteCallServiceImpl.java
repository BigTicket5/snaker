package com.mzz.gateway.service.impl;

import com.mzz.gateway.client.SnakerHttpClient;
import com.mzz.gateway.service.RemoteCallService;
import com.mzz.gateway.util.SnakerStringUtil;
import com.sun.net.httpserver.HttpExchange;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;


@Service
public class DefaultRemoteCallServiceImpl implements RemoteCallService {

    private CloseableHttpClient defaultClient = SnakerHttpClient.initClient();

    @Override
    public Object callRemote(String url, HttpExchange httpExchange) throws IOException {
        if("GET".equals(httpExchange.getRequestMethod())){
            return remoteGet(url,httpExchange.getRequestURI().getRawQuery());
        }
        else if("POST".equals(httpExchange.getRequestMethod())){
            return remotePost(url,httpExchange.getRequestBody().toString());
        }
        return null;
    }

    @Override
    public Object remoteGet(String targetUrl, String params) throws IOException {
        String url = SnakerStringUtil.urlAppend(targetUrl,params);
        System.out.println(url);
        HttpUriRequest getRequest = new HttpGet(url);
        return defaultClient.execute(getRequest);
    }

    @Override
    public Object remotePost(String url, String params) throws IOException {
        return null;
    }
}
