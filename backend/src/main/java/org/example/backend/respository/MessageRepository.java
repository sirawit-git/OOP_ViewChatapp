package org.example.backend.repository;

import org.example.backend.model.MessageModel;

import java.util.List;
import java.util.UUID;

public interface MessageRepository {
    List<MessageModel> getMessages();

    boolean sendMessage(UUID userID, String message);

    boolean deleteMessage(UUID userID, UUID messageID); // soft delete

    MessageModel getMessage(UUID messageID);

    List<MessageModel> searchMessages(String keyword);

    boolean editMessage(UUID userID, UUID messageID, String newMessage);
}
