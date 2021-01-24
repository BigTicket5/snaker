package com.mzz.gateway.service.impl;

import com.mzz.gateway.client.SnakerHttpClient;
import com.mzz.gateway.service.RemoteCallService;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class DefaultRemoteCallServiceImpl implements RemoteCallService {

    @Override
    public Object callRemote(String targetUrl) throws IOException {
        HttpUriRequest getRequest = new HttpGet(targetUrl);
        return SnakerHttpClient.initClient().execute(getRequest);
    }
}
