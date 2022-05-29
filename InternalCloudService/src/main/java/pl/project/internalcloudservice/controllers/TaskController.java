package pl.project.internalcloudservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.project.internalcloudservice.entities.Task;
import pl.project.internalcloudservice.services.TaskService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/taskById/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskService.getTaskById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks() {
        Iterator<Task> taskIterator = taskService.getAllTasks().iterator();
        List<Task> tasks = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        while(taskIterator.hasNext()) {
            tasks.add(taskIterator.next());
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(tasks);
    }

    @PostMapping
    public Task saveTask(@Valid @RequestBody Task task) {
        return taskService.saveTask(task);
    }
}
