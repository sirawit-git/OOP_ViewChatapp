package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.CreateMessage;
import org.example.backend.model.MessageModel;
import org.example.backend.respository.MessageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageRepository messageRepository;

    @GetMapping
    public List<MessageModel> getMessages() {
        return messageRepository.getMessages();
    }

    @PostMapping("/send")
    public boolean sendMessage(@RequestBody CreateMessage message) {
        return messageRepository.sendMessage(
                message.getUserID(),
                message.getMessage()
        );
    }


    @DeleteMapping("/{userID}/{messageID}")
    public boolean deleteMessage(@PathVariable UUID userID,
                                 @PathVariable UUID messageID) {
        return messageRepository.deleteMessage(userID, messageID);
    }


    @GetMapping("/search")
    public List<MessageModel> search(@RequestParam String filter) {
        return messageRepository.searchMessages(filter);
    }


    @PutMapping("/edit")
    public boolean editMessage(@RequestParam UUID userID,
                               @RequestParam UUID messageID,
                               @RequestParam String newMessage) {
        return messageRepository.editMessage(userID, messageID, newMessage);
    }
}
