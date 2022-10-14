package com.stu.order.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;
import org.apache.commons.lang.math.RandomUtils;

import java.util.List;

public class MyRule extends AbstractLoadBalancerRule {


    @Override
    public Server choose(Object key) {
        List<Server> allServers = getLoadBalancer().getAllServers();
        int i = RandomUtils.nextInt(allServers.size());
        return allServers.get(i);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }
}
