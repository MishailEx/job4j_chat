package ru.job4j.job4j_chat.service;

import org.springframework.stereotype.Service;
import ru.job4j.job4j_chat.entity.MessageEntity;
import ru.job4j.job4j_chat.entity.PersonEntity;
import ru.job4j.job4j_chat.entity.RoomEntity;
import ru.job4j.job4j_chat.model.Message;
import ru.job4j.job4j_chat.repository.MessageRepository;
import ru.job4j.job4j_chat.repository.PersonRepository;
import ru.job4j.job4j_chat.repository.RoomRepository;

import java.util.Date;

@Service
public class MessageService {

    private final MessageRepository repository;
    private final RoomRepository roomRepository;
    private final PersonRepository personRepository;


    public MessageService(MessageRepository repository, RoomRepository roomRepository, PersonRepository personRepository) {
        this.repository = repository;
        this.roomRepository = roomRepository;
        this.personRepository = personRepository;
    }

    public Message create(MessageEntity message, int personId, int roomId) {
        PersonEntity personEntity = personRepository.findById(personId).get();
        RoomEntity roomEntity = roomRepository.findById(roomId).get();
        message.setDate(new Date());
        message.setPerson(personEntity);
        message.setRoom(roomEntity);
        repository.save(message);
        return Message.toMessage(message);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
