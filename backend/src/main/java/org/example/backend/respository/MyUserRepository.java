package org.example.backend.respository;

import org.example.backend.model.UserModel;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.*;
import java.util.List;

@Repository
public class MyUserRepository implements org.example.backend.respository.UserRepository {
    private Map<UUID, UserModel> users = new HashMap<>();

    @Override
    public UUID addUser(String username) {
        UserModel userModel = new UserModel(UUID.randomUUID(), username);
        users.put(userModel.getUserID(), userModel);
        return userModel.getUserID();
    }

    @Override
    public UserModel getUserByID(UUID id){
        return users.get(id);
    }
}
