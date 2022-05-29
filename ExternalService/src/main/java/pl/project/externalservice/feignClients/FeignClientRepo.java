package pl.project.externalservice.feignClients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.project.externalservice.entities.FeignEurekaUser;

import java.util.List;

@FeignClient(value = "internal-service")
public interface FeignClientRepo {

    @GetMapping
    String test();

    @GetMapping("/all")
    List<FeignEurekaUser> getAll();

    @GetMapping("/simple")
    FeignEurekaUser getById();

    @GetMapping("/userById/{id}")
    FeignEurekaUser getUserById(@PathVariable("id") Long id);
}
