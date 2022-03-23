package ru.job4j.job4j_chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.job4j_chat.entity.RoomEntity;
import ru.job4j.job4j_chat.model.Room;
import ru.job4j.job4j_chat.service.RoomService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService service;

    @GetMapping
    public List<Room> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> findById(@PathVariable int id) {
        var room = Optional.ofNullable(this.service.findById(id));
        return new ResponseEntity<Room>(
                room.orElse(new Room()),
                room.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @PostMapping
    public ResponseEntity<Room> create(@RequestBody RoomEntity room,
                                       @RequestParam int personId) {
        return new ResponseEntity<Room>(
                this.service.create(room, personId),
                HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody RoomEntity room) {
        this.service.update(room);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
