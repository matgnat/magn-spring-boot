package com.magn.magnspringboot.apicontroller;

import com.magn.magnspringboot.model.User;
import com.magn.magnspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Created by magn on 4/10/2018.
 */
@RestController
@RequestMapping(
        path = "api/users"
)

public class UserApiController {

    private UserService userService;

    @Autowired
    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public List<User> fetchUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "{userUid}"
    )
    public User fetchUser(@PathVariable("userUid") UUID userUid){
        return userService.getUser(userUid).get();

    }



}
