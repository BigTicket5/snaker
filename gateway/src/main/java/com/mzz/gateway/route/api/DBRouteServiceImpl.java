package com.mzz.gateway.route.api;

import com.mzz.gateway.route.RouteDefination;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DBRouteServiceImpl implements IRouteService {

    List<RouteDefination> routeDefinationList = new ArrayList<>();

    public DBRouteServiceImpl(){
        RouteDefination r1 = new RouteDefination();
        r1.setSourcePath("/test");
        List<String> target = new ArrayList<>();
        target.add("https://wwww.taobao.com");
        target.add("https://www.hupu.com");
        target.add("https://www.sina.com.cn/");
        r1.setTargetUrl(target);
        routeDefinationList.add(r1);
        RouteDefination r2 = new RouteDefination();
        r2.setSourcePath("/hello");
        List<String> target2 = new ArrayList<>();
        target2.add("https://www.jd.com");
        r2.setTargetUrl(target2);
        routeDefinationList.add(r2);

    }

    @Override
    public RouteDefination getRoute(String sourcePath) {
        return null;
    }

    @Override
    public Set<RouteDefination> getApiSources(){
        return new HashSet<>(routeDefinationList);
    }
}
