package com.lienming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


/**
 * Created by lienming on 2019/1/11.
 */
@EnableEurekaClient
@RestController
public class HelloController {
    private final Logger logger=Logger.getLogger(String.valueOf(getClass()));

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello/{name}",method = RequestMethod.GET)
    public String testHello(@PathVariable("name")String name){
        ServiceInstance instance=client.getLocalServiceInstance();
        logger.info("serviceId"+instance.getServiceId()+"host:post="+instance.getHost()+":"+instance.getPort());

        return "hello spring client, "+name;
    }
}
