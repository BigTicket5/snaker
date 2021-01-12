package com.mzz.snaker.gateway.route;

import java.util.List;

public class RouteDefination {

    private List<String> targetUrl;

    private String sourcePath;

    public List<String> getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(List<String> targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }
}
