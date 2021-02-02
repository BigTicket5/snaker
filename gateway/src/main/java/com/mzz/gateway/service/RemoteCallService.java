package com.mzz.gateway.service;


import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public interface RemoteCallService {

    Object callRemote(String url,HttpExchange httpExchange) throws IOException;

    Object remoteGet(String url, String params) throws IOException;

    Object remotePost(String url, String params) throws  IOException;
}
