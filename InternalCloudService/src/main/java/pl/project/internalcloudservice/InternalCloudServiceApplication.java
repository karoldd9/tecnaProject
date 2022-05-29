package pl.project.internalcloudservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"pl.project.internalcloudservice.controllers", "pl.project.internalcloudservice.services"})
@EntityScan("pl.project.internalcloudservice.entities")
@EnableJpaRepositories("pl.project.internalcloudservice.repositories")
@EnableEurekaClient
public class InternalCloudServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternalCloudServiceApplication.class, args);
    }

}
