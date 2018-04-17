package com.magn.magnspringboot.service;

import com.magn.magnspringboot.dao.FakeDataDao;
import com.magn.magnspringboot.dao.UserDao;
import static com.magn.magnspringboot.model.User.Gender;

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




    public List<User> getAllUsers(Optional<String> gender) {
        List<User> users = userDao.selectAllUsers();
        if (!gender.isPresent()) {
            return users;
        }
        try {
            Gender theGender = Gender.valueOf(gender.get());

        } catch (Exception e) {
             throw new IllegalStateException("invalid argument" + e);
        }

    }

    public Optional<User> getUser(UUID userID) {
        return userDao.selectUserByUserUid(userID);
    }

    public int updateUser(User user) {
        Optional<User> userOptional = getUser(user.getUserUid());
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
        return userDao.insertUser(UUID.randomUUID(), user);

    }
}
