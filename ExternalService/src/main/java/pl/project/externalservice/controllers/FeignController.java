package pl.project.externalservice.controllers;

import feign.Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import pl.project.externalservice.entities.FeignTask;
import pl.project.externalservice.services.FeignService;
import pl.project.externalservice.tools.RequestAction;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FeignController {

    @Autowired
    FeignService feignService;

    @GetMapping("/all-filterBy={filter}-withValue={filterValue}-sortBy={sort}")
    public List<FeignTask> getAll(@PathVariable("filter") String filter, @PathVariable("filterValue") String filterValue, @PathVariable("sort") String sortBy) {

        int filterAction = switch (filter.toUpperCase()) {
            case "ID" -> RequestAction.ID;
            case "TITLE" -> RequestAction.TITLE;
            case "DESCRIPTION", "DESC" -> RequestAction.DESCRIPTION;
            case "PRIORITY" -> RequestAction.PRIORITY;
            default -> 0;
        };

        int sortAction = switch (sortBy.toUpperCase()) {
            case "ID" -> RequestAction.ID;
            case "TITLE" -> RequestAction.TITLE;
            case "DESCRIPTION", "DESC" -> RequestAction.DESCRIPTION;
            case "PRIORITY" -> RequestAction.PRIORITY;
            default -> 0;
        };

        filterValue = filterValue.toUpperCase();



        List<FeignTask> feignTasks = new ArrayList<>();

        for(FeignTask feignTask : feignService.all()) {
            if(RequestAction.filterFeignTasks(filterAction, filterValue, feignTask))
                feignTasks.add(feignTask);
        }

        RequestAction.sortFeignTasks(feignTasks, sortAction);

        return feignTasks;
    }

    @GetMapping("/taskById/{id}")
    public FeignTask getTaskByID(@PathVariable("id") Long id) {
        return feignService.getTaskById(id);
    }

    @PostMapping("/saveTask")
    public FeignTask saveTask(@Valid @RequestBody FeignTask feignTask) {
        return feignService.saveTask(feignTask);
    }
}
