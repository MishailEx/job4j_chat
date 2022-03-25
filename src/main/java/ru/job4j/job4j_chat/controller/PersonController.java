package ru.job4j.job4j_chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.job4j_chat.entity.PersonEntity;
import ru.job4j.job4j_chat.model.Person;
import ru.job4j.job4j_chat.service.PersonService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService service;


    @GetMapping
    public List<Person> findAll() {
        List<Person> list = this.service.findAll();
        if (list.isEmpty()) {
            throw new NullPointerException("not found");
        }
        return list;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable int id) {
        var person = Optional.ofNullable(this.service.findById(id));
         return new ResponseEntity<Person>(
                person.orElse(new Person()),
                person.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @PostMapping
    public ResponseEntity<Person> create(@Valid @RequestBody PersonEntity person) {
        return new ResponseEntity<Person>(
                this.service.save(person),
                HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody PersonEntity person) {
        this.service.save(person);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
