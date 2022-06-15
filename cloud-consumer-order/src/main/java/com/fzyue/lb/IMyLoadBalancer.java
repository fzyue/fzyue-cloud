package com.fzyue.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface IMyLoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
