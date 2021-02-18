package com.mzz.gateway.service.impl;

import com.mzz.gateway.client.SnakerHttpClient;
import com.mzz.gateway.service.RemoteCallService;
import com.mzz.gateway.util.SnakerStringUtil;
import com.sun.net.httpserver.HttpExchange;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;


@Service
public class DefaultRemoteCallServiceImpl implements RemoteCallService {

    private CloseableHttpClient defaultClient = SnakerHttpClient.initClient();

    @Override
    public Object callRemote(String url, HttpExchange httpExchange) throws IOException {
        if("GET".equals(httpExchange.getRequestMethod())){
            httpExchange.getRequestHeaders();
            return remoteGet(url,httpExchange.getRequestURI().getRawQuery());
        }
        else if("POST".equals(httpExchange.getRequestMethod())){
            return remotePost(url,httpExchange.getRequestBody());
        }
        return null;
    }

    @Override
    public Object remoteGet(String targetUrl, String params) throws IOException {
        String url = SnakerStringUtil.urlAppend(targetUrl,params);
        HttpUriRequest getRequest = new HttpGet(url);
        return defaultClient.execute(getRequest);
    }

    @Override
    public Object remotePost(String url, InputStream is) throws IOException {
        //TODO need to move inputstream reading part out to util class
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(is, "UTF-8");

        for (; ; ) {
            int rsz = in.read(buffer, 0, buffer.length);
            if (rsz < 0)
                break;
            out.append(buffer, 0, rsz);
        }
        HttpPost postReq = new HttpPost(url);
        postReq.setHeader("Content-type","application/json");
        HttpEntity entity = new ByteArrayEntity(out.toString().getBytes("UTF-8"));
        postReq.setEntity(entity);
        return defaultClient.execute(postReq);
    }
}
