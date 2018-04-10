package com.magn.magnspringboot.service;

import com.magn.magnspringboot.dao.UserDao;
import com.magn.magnspringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.selectAllUsers();
    }

    public Optional<User> getUser(UUID userID) {
        return userDao.selectUserByUserUid(userID);
    }

    public int updateUser(User user) {
        Optional<User> userOptional = getUser(user.getUserID());
        if (userOptional.isPresent()) {
            userDao.updateUser(user);
            return 1;
        }
        return -1;
    }

    public int removeUser(UUID userUid) {
        Optional<User> userOptional = getUser(userUid);
        if (userOptional.isPresent()) {
            userDao.deleteUserByUserUid(userUid);
            return 1;
        }
        return -1;
    }

    public int insertUser(User user) {
        UUID userUid = UUID.randomUUID();
        return userDao.insertUser(userUid, user);
    }
}
