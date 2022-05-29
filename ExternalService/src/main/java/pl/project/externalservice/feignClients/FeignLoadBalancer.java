package pl.project.externalservice.feignClients;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

@LoadBalancerClient(value = "internal-service")
public class FeignLoadBalancer {

    @LoadBalanced
    @Bean
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
