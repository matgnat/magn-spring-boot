package com.magn.magnspringboot.dao;

import com.magn.magnspringboot.model.User;

import java.util.*;

public class FakeDataDao implements UserDao{

    private static Map<UUID, User> database;

    static {
        
        database = new HashMap<>();
        UUID userUid = UUID.randomUUID();
        database.put(userUid, new User(userUid, "John", "Smith", User.Gender.MAIL, 22, "john.smith@gmail.com"));
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(database.values());
    }

    @Override
    public User getUser(UUID userID) {
        return database.get(userID);
    }

    @Override
    public int updateUser(User user) {
        database.put(user.getUserID(), user);
        return 1;
    }

    @Override
    public int removeUser(UUID userUid) {
        database.remove(userUid);
        return 1;
    }

    @Override
    public int insertUser(UUID userUid, User user) {
        database.put(userUid, user);
        return 1;
    }
}
