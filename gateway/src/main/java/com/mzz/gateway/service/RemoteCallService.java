package com.mzz.gateway.service;


import java.io.IOException;

public interface RemoteCallService {

    Object callRemote(String url) throws IOException;
}
