package com.kisan.controller;

import com.kisan.dto.MessageRequestDTO;
import com.kisan.dto.MessageResponseDTO;
import com.kisan.service.MessageService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "http://localhost:3000")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<List<MessageResponseDTO>> getAll() {
        List<MessageResponseDTO> allMessages = messageService.getAllMessages();
        return ResponseEntity.ok(allMessages);
    }

    @PostMapping
    public ResponseEntity<MessageResponseDTO> sendMessage(@RequestBody @Valid MessageRequestDTO message) {
        MessageResponseDTO newMessage = messageService.saveMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMessage);
    }
}