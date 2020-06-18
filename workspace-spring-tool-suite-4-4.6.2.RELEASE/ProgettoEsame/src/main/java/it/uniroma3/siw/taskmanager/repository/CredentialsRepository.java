package it.uniroma3.siw.taskmanager.repository;
import it.uniroma3.siw.taskmanager.model.Credentials;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CredentialsRepository extends CrudRepository<Credentials, Long> {

  
    public Optional<Credentials> findByUserName(String username);
}



