package pl.project.externalservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.project.externalservice.entities.FeignEurekaUser;
import pl.project.externalservice.services.FeignService;

@RestController
public class FeignController {

    @Autowired
    FeignService feignService;

    @GetMapping
    public String test() {
        return feignService.test();
    }

    @GetMapping("/all")
    public ResponseEntity getAll() {
        return feignService.all();
    }

    @GetMapping("/user")
    public FeignEurekaUser getById() {
        return feignService.user();
    }
}
