package com.mzz.gateway.service;

import org.apache.http.HttpResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

public interface RemoteCallService {

    Object callRemote(String url) throws IOException;
}
