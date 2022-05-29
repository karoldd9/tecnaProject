package pl.project.externalservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.project.externalservice.entities.FeignEurekaUser;
import pl.project.externalservice.feignClients.FeignClientRepo;

import java.util.List;

@Service
public class FeignService {

    @Autowired
    FeignClientRepo feignClientRepo;

    public String test() {
        return feignClientRepo.test();
    }

    public List<FeignEurekaUser> all() {
        return feignClientRepo.getAll();
    }

    public FeignEurekaUser user() {
        return feignClientRepo.getById();
    }

    public FeignEurekaUser userById(Long id) {
        return feignClientRepo.getUserById(id);
    }
}
