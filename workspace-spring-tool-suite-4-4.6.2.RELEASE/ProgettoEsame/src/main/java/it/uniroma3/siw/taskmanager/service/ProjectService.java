package it.uniroma3.siw.taskmanager.service;

import it.uniroma3.siw.taskmanager.model.Project;
import it.uniroma3.siw.taskmanager.model.User;
import it.uniroma3.siw.taskmanager.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;


@Service
public class ProjectService {

    @Autowired
    protected ProjectRepository projectRepository;

    
    @Transactional
    public Project getProject(long id) {
        Optional<Project> result = this.projectRepository.findById(id);
        return result.orElse(null);
    }

   
    @Transactional
    public Project saveProject(Project project) {
        return this.projectRepository.save(project);
    }

   
    @Transactional
    public void deleteProject(Project project) {
        this.projectRepository.delete(project);
    }

    
    @Transactional
    public Project shareProjectWithUser(Project project, User user) {
        project.addMember(user);
        return this.projectRepository.save(project);
    }
}
