package it.uniroma3.siw.taskmanager.service;

import it.uniroma3.siw.taskmanager.model.Task;
import it.uniroma3.siw.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class TaskService {

    @Autowired
    protected TaskRepository taskRepository;

  
    @Transactional
    public Task getTask(long id) {
        Optional<Task> result = this.taskRepository.findById(id);
        return result.orElse(null);
    }

  
    @Transactional
    public Task saveTask(Task task) {
        return this.taskRepository.save(task);
    }

    @Transactional
    public Task setCompleted(Task task) {
        task.setCompleted(true);
        return this.taskRepository.save(task);
    }


    @Transactional
    public void deleteTask(Task task) {
        this.taskRepository.delete(task);
    }
}
