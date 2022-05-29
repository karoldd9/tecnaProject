package pl.project.externalservice.feignClients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.project.externalservice.entities.FeignEurekaUser;

@FeignClient(value = "internal-service")
public interface FeignClientRepo {

    @GetMapping
    String test();

    @GetMapping("/all")
    ResponseEntity<?> getAll();

    @GetMapping("/simple")
    FeignEurekaUser getById();
}
