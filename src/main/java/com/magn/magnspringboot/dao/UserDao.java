package com.magn.magnspringboot.dao;

import com.magn.magnspringboot.model.User;

import java.util.List;
import java.util.UUID;

/**
 * Created by magn on 4/6/2018.
 */
public interface UserDao {

    List<User> selectAllUsers();

    User selectUserByUserUid(UUID userID);

    int updateUser(User user);

    int deleteUserByUserUid(UUID userUid);

    int insertUser(UUID userUid, User user);
}
