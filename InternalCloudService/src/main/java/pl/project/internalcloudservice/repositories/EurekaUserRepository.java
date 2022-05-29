package pl.project.internalcloudservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.project.internalcloudservice.entities.EurekaUser;

@Repository
public interface EurekaUserRepository extends CrudRepository<EurekaUser, Long> {
}
