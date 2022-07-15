package ru.job4j.job4j_chat.model;

import ru.job4j.job4j_chat.entity.PersonEntity;

public class Person {
    private int id;
    private String name;
    private String role;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public static Person toPerson(PersonEntity personEntity) {
      Person person = new Person();
      person.setId(personEntity.getId());
      person.setName(personEntity.getName());
      person.setRole(personEntity.getRole().getName());
      return person;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
