package com.mzz.gateway.service;


import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;

public interface RemoteCallService {

    Object callRemote(String url,HttpExchange httpExchange) throws IOException;

    Object remoteGet(String url, String params) throws IOException;

    Object remotePost(String url, InputStream is) throws  IOException;
}
