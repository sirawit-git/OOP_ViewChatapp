package org.example.backend.respository;

import org.apache.catalina.User;
import org.example.backend.model.UserModel;

import java.util.UUID;

public interface UserRepository {
    UUID addUser(String username);
    UserModel getUserByID(UUID id);
}
