package com.mzz.gateway;
import com.mzz.gateway.util.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args){
        ApplicationContext applicationContext = SpringApplication.run(GatewayApplication.class,args);
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for(String bn : beanNames){
            System.out.println(bn);
        }
    }
}
