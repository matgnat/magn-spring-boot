package com.magn.magnspringboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

/**
 * Created by magn on 4/6/2018.
 */
public class User {

    //userUid
    private final UUID userUid;
    private final String firstName;
    private final String lastName;
    private final Gender gender;
    private final Integer age;
    private final String email;

    public User(
            @JsonProperty("userUid") UUID userUid,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("gender") Gender gender,
            @JsonProperty("age") Integer age,
            @JsonProperty("email") String email) {
        this.userUid = userUid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }



    /*this one has to be in order to POST request (default constructor were needed).
    Consequently, becouse of default contructor varieables could not be final
    Deprecated -> use @JsonProperty

    public User() {
    }*/



    public UUID getUserUid() {
        return userUid;
    }

/*    public void setUserUid(UUID userUid) {
        this.userUid = userUid;
    }*/

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public static User newUser(UUID userUid, User user) {
        return new User(userUid, user.getFirstName(), user.getLastName(), user.getGender(), user.getAge(), user.getEmail() );
    }

    @Override
    public String toString() {
        return "User{" +
                "userUid=" + userUid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public enum Gender {
        MAIL,
        FEMAIL
    }


}



