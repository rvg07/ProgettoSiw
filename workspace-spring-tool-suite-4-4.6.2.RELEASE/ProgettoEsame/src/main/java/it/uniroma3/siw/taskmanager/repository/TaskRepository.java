package it.uniroma3.siw.taskmanager.repository;
import it.uniroma3.siw.taskmanager.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

}

