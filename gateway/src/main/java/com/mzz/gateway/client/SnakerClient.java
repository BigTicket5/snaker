package com.mzz.gateway.client;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SnakerClient {
    String clientName () default  "SnakerClient";
}
