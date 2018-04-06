package com.magn.magnspringboot.dao;

import com.magn.magnspringboot.model.User;

import java.util.List;
import java.util.UUID;

/**
 * Created by magn on 4/6/2018.
 */
public interface UserDao {

    List<User> getAllUsers();
    User getUser(UUID userID);
    int updateUser(User user);
    int removeUser(UUID userUid);
    int insertUser(User user);
}
