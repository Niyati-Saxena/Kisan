package com.kisan.controller;

import com.kisan.model.Message;
import com.kisan.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "http://localhost:3000")
public class MessageController {

    @Autowired
    private MessageRepository repo;

    @GetMapping
    public List<Message> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Message sendMessage(@RequestBody Message message) {
        return repo.save(message);
    }
}