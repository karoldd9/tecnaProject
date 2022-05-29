package pl.project.externalservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.externalservice.entities.FeignTask;
import pl.project.externalservice.feignClients.FeignClientRepo;
import pl.project.externalservice.tools.RequestAction;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeignService {

    @Autowired
    FeignClientRepo feignClientRepo;

    public List<FeignTask> all() {
        return feignClientRepo.getAll();
    }

    public FeignTask getTaskById(Long id) {
        return feignClientRepo.getTaskByID(id);
    }

    public FeignTask saveTask(FeignTask feignTask) {
        return feignClientRepo.saveTask(feignTask);
    }

    public List<FeignTask> getFiltered(String filter, String filterValue) {
        int filterAction = switch (filter.toUpperCase()) {
            case "ID" -> RequestAction.ID;
            case "TITLE" -> RequestAction.TITLE;
            case "DESCRIPTION", "DESC" -> RequestAction.DESCRIPTION;
            case "PRIORITY" -> RequestAction.PRIORITY;
            default -> 0;
        };

        filterValue = filterValue.toUpperCase();

        List<FeignTask> feignTasks = new ArrayList<>();

        for(FeignTask feignTask : all()) {
            if(RequestAction.filterFeignTasks(filterAction, filterValue, feignTask))
                feignTasks.add(feignTask);
        }

        return feignTasks;
    }

    public List<FeignTask> getSorted(String sortBy) {
        int sortAction = switch (sortBy.toUpperCase()) {
            case "ID" -> RequestAction.ID;
            case "TITLE" -> RequestAction.TITLE;
            case "DESCRIPTION", "DESC" -> RequestAction.DESCRIPTION;
            case "PRIORITY" -> RequestAction.PRIORITY;
            default -> 0;
        };

        List<FeignTask> feignTasks = all();

        RequestAction.sortFeignTasks(feignTasks, sortAction);

        return feignTasks;
    }
}
