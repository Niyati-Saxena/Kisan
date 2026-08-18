package com.kisan.mapper;

import com.kisan.dto.MessageRequestDTO;
import com.kisan.dto.MessageResponseDTO;
import com.kisan.model.Message;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageMapper {
    public Message toEntity(MessageRequestDTO request) {
        Message message = new Message();

        message.setMessage(request.message());
        message.setEmail(request.email());
        message.setName(request.name());

        return message;
    }

    public MessageResponseDTO toDto(Message message) {
        return new MessageResponseDTO( message.getName(),message.getEmail(), message.getMessage());
    }

    public List<MessageResponseDTO> toDtoList(List<Message> message) {
        return message.stream().map(this::toDto).toList();
    }
}
