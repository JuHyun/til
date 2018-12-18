package com.example.aoppractice2.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String loginId;

    private String password;

    private String name;

    public static User create(String loginId, String password, String name) {
        User user = new User();
        user.setLoginId(loginId);
        user.setPassword(password);
        user.setName(name);

        return user;
    }
}
