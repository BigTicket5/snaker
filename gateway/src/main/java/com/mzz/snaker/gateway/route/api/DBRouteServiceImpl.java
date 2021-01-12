package com.mzz.snaker.gateway.route.api;

import com.mzz.snaker.gateway.route.RouteDefination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBRouteServiceImpl implements IRouteService {

    Map<String,RouteDefination> routeMap = new HashMap<>();

    public DBRouteServiceImpl(){
        RouteDefination r1 = new RouteDefination();
        r1.setSourcePath("/test");
        List<String> target = new ArrayList<>();
        target.add("/test/1");
        target.add("/test/2");
        target.add("/test/3");
        r1.setTargetUrl(target);
        routeMap.put("/test",r1);
    }

    public RouteDefination getRoute(String sourcePath) {
        return routeMap.get(sourcePath);
    }
}
