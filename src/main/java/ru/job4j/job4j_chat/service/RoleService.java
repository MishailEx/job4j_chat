package ru.job4j.job4j_chat.service;

import org.springframework.stereotype.Service;
import ru.job4j.job4j_chat.entity.RoleEntity;
import ru.job4j.job4j_chat.model.Role;
import ru.job4j.job4j_chat.repository.RoleRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoleService {

    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public List<Role> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(Role::toRole)
                .collect(Collectors.toList()) ;
    }

    public RoleEntity save(RoleEntity role) {
        return repository.save(role);
    }

    public RoleEntity findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
