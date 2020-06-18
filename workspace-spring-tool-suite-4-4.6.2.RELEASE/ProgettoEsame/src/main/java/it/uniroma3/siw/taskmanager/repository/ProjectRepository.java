package it.uniroma3.siw.taskmanager.repository;
import it.uniroma3.siw.taskmanager.model.Project;
import it.uniroma3.siw.taskmanager.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProjectRepository extends CrudRepository<Project, Long> {

    public List<Project> findByMembers(User member);


    public List<Project> findByOwner(User owner);
}

