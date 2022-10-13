//package com.stu.order.loadbalancerule;
//
//import com.netflix.client.config.IClientConfig;
//import com.netflix.loadbalancer.AbstractLoadBalancerRule;
//import com.netflix.loadbalancer.Server;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//@Slf4j
//public class MyRule extends AbstractLoadBalancerRule {
//
//
//    @Override
//    public void initWithNiwsConfig(IClientConfig clientConfig) {
//
//    }
//
//    @Override
//    public Server choose(Object key) {
//        List<Server> allServers = getLoadBalancer().getReachableServers();
//        log.info(allServers.toString());
//        return allServers.get(0);
//    }
//}
