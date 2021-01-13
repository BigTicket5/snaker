package com.mzz.gateway.route.api;


import com.mzz.gateway.route.RouteDefination;

public interface IRouteService {
    RouteDefination getRoute(String sourcePath);
}
