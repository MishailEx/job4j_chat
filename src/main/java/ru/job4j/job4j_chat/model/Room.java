package ru.job4j.job4j_chat.model;

import ru.job4j.job4j_chat.entity.MessageEntity;
import ru.job4j.job4j_chat.entity.RoomEntity;

import java.util.Date;
import java.util.List;

public class Room {

    private int id;
    private String name;
    private Date date;
    private String personName;
    private List<MessageEntity> messages;

    public Room() {
    }

    public Room(int id, String name, Date date, String personName) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.personName = personName;
    }

    public static Room toRoom(RoomEntity room) {
        return new Room(room.getId(), room.getName(), room.getDate(), room.getPerson().getName());
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public List<MessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageEntity> messages) {
        this.messages = messages;
    }
}
