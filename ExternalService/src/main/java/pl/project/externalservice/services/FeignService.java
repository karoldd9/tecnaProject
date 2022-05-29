package pl.project.externalservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.project.externalservice.entities.FeignEurekaUser;
import pl.project.externalservice.feignClients.FeignClientRepo;

@Service
public class FeignService {

    @Autowired
    FeignClientRepo feignClientRepo;

    public String test() {
        return feignClientRepo.test();
    }

    public ResponseEntity<?> all() {
        return feignClientRepo.getAll();
    }

    public FeignEurekaUser user() {
        return feignClientRepo.getById();
    }
}
