package ru.job4j.job4j_chat.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.job4j_chat.entity.PersonEntity;

public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {
    PersonEntity findByName(String username);
}
