package ru.job4j.job4j_chat.model;

import ru.job4j.job4j_chat.entity.RoleEntity;

public class Role {

    private int id;
    private String name;

    public Role() {
    }

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Role toRole(RoleEntity role) {
        return new Role(role.getId(), role.getName());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
