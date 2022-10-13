package com.stu.order.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {
        List<Server> allServers = getLoadBalancer().getAllServers();
        System.out.println(allServers.toArray());
        return null;
    }
}
