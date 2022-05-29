package pl.project.internalcloudservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.project.internalcloudservice.entities.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
