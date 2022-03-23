package ru.job4j.job4j_chat.model;

import ru.job4j.job4j_chat.entity.MessageEntity;

import java.util.Date;

public class Message {
    private String description;
    private Date date;
    private String name;

    public Message() {
    }

    public Message(String description, Date date, String name) {
        this.description = description;
        this.date = date;
        this.name = name;
    }

    public static Message toMessage(MessageEntity message) {
        return new Message(message.getDescription(), message.getDate(), message.getPerson().getName());
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
