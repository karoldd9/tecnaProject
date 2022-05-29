package pl.project.externalservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.externalservice.entities.FeignTask;
import pl.project.externalservice.feignClients.FeignClientRepo;

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
}
