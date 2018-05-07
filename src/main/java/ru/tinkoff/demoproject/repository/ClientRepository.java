package ru.tinkoff.demoproject.repository;

import org.springframework.data.repository.CrudRepository;
import ru.tinkoff.demoproject.entity.Client;


public interface ClientRepository extends CrudRepository<Client, Long> {

}
