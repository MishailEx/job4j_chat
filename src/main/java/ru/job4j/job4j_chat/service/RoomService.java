package ru.job4j.job4j_chat.service;

import org.springframework.stereotype.Service;
import ru.job4j.job4j_chat.entity.PersonEntity;
import ru.job4j.job4j_chat.entity.RoomEntity;
import ru.job4j.job4j_chat.model.Room;
import ru.job4j.job4j_chat.repository.PersonRepository;
import ru.job4j.job4j_chat.repository.RoomRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoomService {
    private final RoomRepository repository;
    private final PersonRepository personRepository;

    public RoomService(RoomRepository repository, PersonRepository personRepository) {
        this.repository = repository;
        this.personRepository = personRepository;
    }

    public List<Room> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(Room::toRoom)
                .collect(Collectors.toList()) ;
    }

    public Room findById(int id) {
        RoomEntity roomEntity = repository.findById(id).get();
        Room room = Room.toRoom(roomEntity);
        room.setMessages(roomEntity.getMessages());
        return room;
    }

    public Room create(RoomEntity room, int personId) {
        PersonEntity person = personRepository.findById(personId).get();
        room.setPerson(person);
        room.setDate(new Date());
        repository.save(room);
        return Room.toRoom(room);
    }

    public void update(RoomEntity room) {
        repository.save(room);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
