package com.mzz.gateway.config;

import com.mzz.gateway.route.api.IRouteService;
import com.mzz.gateway.server.SnakerServer;
import com.mzz.gateway.service.RemoteCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class SnakerConfig {

    @Resource(name="${snaker.route.service}")
    private IRouteService routeService;

    @Bean
    public SnakerServer getSnakerServer() throws IOException {
        SnakerServer snakerServer = new SnakerServer();
        Executor executor = Executors.newCachedThreadPool();
        snakerServer.bind(new InetSocketAddress(8888), 0 );
        snakerServer.addRoutes(routeService.getApiSources());
        snakerServer.setExecutor(executor);
        snakerServer.start();
        return  snakerServer;
    }
}
