package ru.job4j.job4j_chat.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;
    @OneToMany(mappedBy = "person")
    private List<MessageEntity> messageEntityList;
    @OneToMany(mappedBy = "person")
    private List<RoomEntity> rooms;

    public PersonEntity() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public List<MessageEntity> getMessageEntityList() {
        return messageEntityList;
    }

    public void setMessageEntityList(List<MessageEntity> messageEntityList) {
        this.messageEntityList = messageEntityList;
    }

    public List<RoomEntity> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomEntity> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonEntity that = (PersonEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(password, that.password) && Objects.equals(role, that.role) && Objects.equals(messageEntityList, that.messageEntityList) && Objects.equals(rooms, that.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, role, messageEntityList, rooms);
    }
}
