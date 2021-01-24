package com.mzz.gateway.client;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;


@SnakerClient
public class SnakerHttpClient {

    public static CloseableHttpClient initClient(){
        PoolingHttpClientConnectionManager httpClientConnectionManager = new PoolingHttpClientConnectionManager();
        httpClientConnectionManager.setMaxTotal(50);
        httpClientConnectionManager.setDefaultMaxPerRoute(10);

        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30000).setSocketTimeout(30000)
                .setConnectionRequestTimeout(30000)
                .build();
        LaxRedirectStrategy redirectStrategy = new LaxRedirectStrategy();
        SocketConfig socketConfig = SocketConfig.custom()
                .setSoKeepAlive(false)
                .setSoLinger(1)
                .setSoReuseAddress(true)
                .setSoTimeout(10000).build();
        CloseableHttpClient client = HttpClientBuilder.create()
                .setConnectionManager(httpClientConnectionManager)
                .setDefaultRequestConfig(requestConfig)
                .setRedirectStrategy(redirectStrategy)
                .setDefaultSocketConfig(socketConfig)
                .setUserAgent(HttpContants.USER_AGENT)
                .build();
        return client;

    }
}
