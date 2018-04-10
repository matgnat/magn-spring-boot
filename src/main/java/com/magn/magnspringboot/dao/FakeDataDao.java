package com.magn.magnspringboot.dao;

import com.magn.magnspringboot.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FakeDataDao implements UserDao{

    private static Map<UUID, User> database;

    static {
        
        database = new HashMap<>();
        UUID userUid = UUID.randomUUID();
        database.put(userUid, new User(userUid, "John", "Smith", User.Gender.MAIL, 22, "john.smith@gmail.com"));
    }

    @Override
    public List<User> selectAllUsers() {
        return new ArrayList<>(database.values());
    }

    @Override
    public Optional<User> selectUserByUserUid(UUID userID) {
        return Optional.ofNullable(database.get(userID));
    }

    @Override
    public int updateUser(User user) {
        database.put(user.getUserID(), user);
        return 1;
    }

    @Override
    public int deleteUserByUserUid(UUID userUid) {
        database.remove(userUid);
        return 1;
    }

    @Override
    public int insertUser(UUID userUid, User user) {
        database.put(userUid, user);
        return 1;
    }
}
