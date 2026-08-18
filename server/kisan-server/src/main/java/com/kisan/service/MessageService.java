package com.kisan.service;

import com.kisan.dto.MessageRequestDTO;
import com.kisan.dto.MessageResponseDTO;
import com.kisan.mapper.MessageMapper;
import com.kisan.model.Message;
import com.kisan.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public MessageService(MessageRepository messageRepository, MessageMapper messageMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }

    public List<MessageResponseDTO> getAllMessages() {
        List<Message> allMessages =  messageRepository.findAll();
        return messageMapper.toDtoList(allMessages);
    }

    public MessageResponseDTO saveMessage(MessageRequestDTO request) {
        Message message = messageRepository.save(messageMapper.toEntity(request));
        return messageMapper.toDto(message);
    }

}
