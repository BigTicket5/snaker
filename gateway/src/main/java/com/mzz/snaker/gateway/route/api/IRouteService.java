package com.mzz.snaker.gateway.route.api;


import com.mzz.snaker.gateway.route.RouteDefination;

public interface IRouteService {
    RouteDefination getRoute(String sourcePath);
}
