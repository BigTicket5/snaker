package com.mzz.gateway;

import com.mzz.gateway.route.api.DBRouteServiceImpl;
import com.mzz.gateway.route.api.IRouteService;
import com.mzz.gateway.server.SnakerRouteHandler;
import com.mzz.gateway.server.SnakerServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class GatewayApplication {

    public GatewayApplication(){
        try {
            SnakerServer snakerServer = new SnakerServer();
            Executor executor = Executors.newCachedThreadPool();
            snakerServer.bind(new InetSocketAddress(8888), 0 );
            IRouteService routeService = new DBRouteServiceImpl();
            snakerServer.addRoutes(routeService.getApiSources());
            snakerServer.setExecutor(executor);
            snakerServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args){
        GatewayApplication gatewayApplication = new GatewayApplication();
    }
}
