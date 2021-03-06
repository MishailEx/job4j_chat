package ru.job4j.job4j_chat.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.job4j.job4j_chat.entity.PersonEntity;
import ru.job4j.job4j_chat.entity.RoleEntity;
import ru.job4j.job4j_chat.model.Person;
import ru.job4j.job4j_chat.repository.PersonRepository;
import ru.job4j.job4j_chat.repository.RoleRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonService {

    private final PersonRepository repository;
    private final RoleRepository roleRepository;
    private BCryptPasswordEncoder encoder;

    public PersonService(PersonRepository repository, RoleRepository roleRepository, BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    public List<Person> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(Person::toPerson)
                .collect(Collectors.toList()) ;
    }

    public Person save(PersonEntity person) {
        RoleEntity role = roleRepository.findByName("user");
        person.setRole(role);
        person.setPassword(encoder.encode(person.getPassword()));
        repository.save(person);
        return Person.toPerson(person);
    }

    public Person findById(int id) {
        return Person.toPerson(repository.findById(id).get());
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
