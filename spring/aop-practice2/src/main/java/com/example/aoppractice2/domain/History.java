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
@AllArgsConstructor
@NoArgsConstructor
public class History {

    @Id
    @GeneratedValue
    private Long id;

    private boolean success;

    private String loginId;

    private String reason;

    public static History create(boolean success, String loginId, String reason) {
        History history = new History();
        history.setSuccess(success);
        history.setLoginId(loginId);
        history.setReason(reason);

        return history;
    }
}
