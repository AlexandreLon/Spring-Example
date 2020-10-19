package fr.polytech.al.trainmanagement.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.polytech.al.trainmanagement.models.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
    @Query("SELECT coalesce(max(e.id), 0) FROM Task e")
    Long getMaxId();
}
