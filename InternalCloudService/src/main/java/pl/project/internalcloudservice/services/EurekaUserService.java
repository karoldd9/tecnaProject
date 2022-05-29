package pl.project.internalcloudservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import pl.project.internalcloudservice.entities.EurekaUser;
import pl.project.internalcloudservice.repositories.EurekaUserRepository;

@Service
public class EurekaUserService {

    @Autowired
    EurekaUserRepository eurekaUserRepository;


    public EurekaUser getEurekaUserById(Long id) {
        return eurekaUserRepository.findById(id).get();
    }

    public Iterable<EurekaUser> getAllEurekaUsers() {
        return eurekaUserRepository.findAll();
    }

    public EurekaUser saveEurekaUser(EurekaUser eurekaUser) {
        return eurekaUserRepository.save(eurekaUser);
    }
}
