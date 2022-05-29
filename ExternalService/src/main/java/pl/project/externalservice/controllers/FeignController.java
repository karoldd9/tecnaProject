package pl.project.externalservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.project.externalservice.entities.FeignEurekaUser;
import pl.project.externalservice.services.FeignService;
import pl.project.externalservice.tools.RequestAction;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FeignController {

    @Autowired
    FeignService feignService;

    @GetMapping
    public String test() {
        return feignService.test();
    }

    @GetMapping("/all-filterBy={filter}-withValue={filterValue}")
    public List<FeignEurekaUser> getAll(@PathVariable("filter") String filter, @PathVariable("filterValue") String filterValue) {

        int filterInt = switch (filter.toUpperCase()) {
            case "ID" -> RequestAction.ID;
            case "REALNAME" -> RequestAction.REAL_NAME;
            case "USERNAME" -> RequestAction.USER_NAME;
            case "LASTNAME" -> RequestAction.LAST_NAME;
            default -> 0;
        };


        List<FeignEurekaUser> feignUsers = new ArrayList<>();

        for(FeignEurekaUser feignEurekaUser: feignService.all()) {
            if(RequestAction.filterEurekaUser(filterInt, filterValue, feignEurekaUser))
                feignUsers.add(feignEurekaUser);
        }
        return feignUsers;
    }

    @GetMapping("/user")
    public FeignEurekaUser getById() {
        return feignService.user();
    }

    @GetMapping("/userById/{id}")
    public FeignEurekaUser userById(@PathVariable("id") Long id) {
        return feignService.userById(id);
    }
}
