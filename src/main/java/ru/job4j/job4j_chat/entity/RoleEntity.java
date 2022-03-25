package ru.job4j.job4j_chat.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

@Entity(name = "role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "role")
    private List<PersonEntity> personEntityList;

    public RoleEntity() {
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

    public List<PersonEntity> getPersonEntityList() {
        return personEntityList;
    }

    public void setPersonEntityList(List<PersonEntity> personEntityList) {
        this.personEntityList = personEntityList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RoleEntity that = (RoleEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(personEntityList, that.personEntityList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, personEntityList);
    }
}
