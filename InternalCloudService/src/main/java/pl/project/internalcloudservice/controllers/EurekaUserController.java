package pl.project.internalcloudservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.project.internalcloudservice.entities.EurekaUser;
import pl.project.internalcloudservice.services.EurekaUserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@RestController
public class EurekaUserController {

    @Autowired
    EurekaUserService eurekaUserService;

    @GetMapping("/simple")
    public ResponseEntity<EurekaUser> getSimpleEurekaUser() {
        //RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(eurekaUserService.getAllEurekaUsers().iterator().next());
    }

    @GetMapping("/byId")
    public EurekaUser getEurekaUserById(Long id) {
        return eurekaUserService.getEurekaUserById(id);
    }

    @GetMapping("/all")
    public List<EurekaUser> getAllEurekaUsers() {
        Iterator<EurekaUser> eurekaUserIterator = eurekaUserService.getAllEurekaUsers().iterator();
        List<EurekaUser> eurekaUsers = new ArrayList<>();

        while(eurekaUserIterator.hasNext()) {
            eurekaUsers.add(eurekaUserIterator.next());
        }

        return eurekaUsers;
    }

    @GetMapping
    public String test() {
        return "Tested successfully";
    }

    @PostMapping
    public EurekaUser saveEurekaUser(@Valid @RequestBody EurekaUser eurekaUser) {
        return eurekaUserService.saveEurekaUser(eurekaUser);
    }
}
