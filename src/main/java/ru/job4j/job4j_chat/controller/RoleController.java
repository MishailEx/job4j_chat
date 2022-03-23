package ru.job4j.job4j_chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.job4j.job4j_chat.model.Role;
import ru.job4j.job4j_chat.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService service;

    @GetMapping
    public List<Role> findAll() {
        return this.service.findAll();
    }
}
