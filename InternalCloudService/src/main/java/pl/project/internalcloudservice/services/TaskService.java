package pl.project.internalcloudservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.internalcloudservice.entities.Task;
import pl.project.internalcloudservice.repositories.TaskRepository;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;


    public Task getTaskById(Long id) {
        return taskRepository.findById(id).get();
    }

    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
}
