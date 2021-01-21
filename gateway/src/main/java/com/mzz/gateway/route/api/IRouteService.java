package com.mzz.gateway.route.api;


import com.mzz.gateway.route.RouteDefination;

import java.util.Set;

public interface IRouteService {
    RouteDefination getRoute(String sourcePath);
    Set<RouteDefination> getApiSources();
}
