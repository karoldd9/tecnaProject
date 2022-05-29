package pl.project.externalservice.feignClients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.project.externalservice.entities.FeignTask;

import java.util.List;

@FeignClient(value = "internal-service")
public interface FeignClientRepo {

    @GetMapping("/all")
    List<FeignTask> getAll();

    @GetMapping("/taskById/{id}")
    FeignTask getTaskByID(@PathVariable("id") Long id);

    @PostMapping
    FeignTask saveTask(FeignTask feignTask);
}
