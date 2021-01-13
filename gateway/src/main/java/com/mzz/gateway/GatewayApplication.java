package com.mzz.gateway;

import com.mzz.gateway.server.SnakerRouteHandler;
import com.mzz.gateway.server.SnakerServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class GatewayApplication {

    public GatewayApplication(){
        try {
            SnakerServer snakerServer = new SnakerServer();
            snakerServer.bind(new InetSocketAddress(8888), 0 );
            snakerServer.createContext("/test",new SnakerRouteHandler("/test"));
            snakerServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args){
        GatewayApplication gatewayApplication = new GatewayApplication();
    }
}
