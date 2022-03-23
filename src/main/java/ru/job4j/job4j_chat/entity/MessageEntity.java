package ru.job4j.job4j_chat.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "message")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity room;

    public MessageEntity() {
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MessageEntity that = (MessageEntity) o;
        return id == that.id && Objects.equals(description, that.description) && Objects.equals(date, that.date) && Objects.equals(person, that.person) && Objects.equals(room, that.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, date, person, room);
    }
}
