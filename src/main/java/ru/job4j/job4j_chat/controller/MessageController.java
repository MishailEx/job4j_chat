package ru.job4j.job4j_chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.job4j_chat.entity.MessageEntity;
import ru.job4j.job4j_chat.model.Message;
import ru.job4j.job4j_chat.service.MessageService;


@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService service;

    @PostMapping
    public ResponseEntity<Message> create(@RequestBody MessageEntity message,
                                              @RequestParam int personId,
                                          @RequestParam int roomId) {
        return new ResponseEntity<Message>(
                this.service.create(message, personId, roomId),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
