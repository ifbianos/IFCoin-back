package com.ifba.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Slf4j
public class PasswordToken {

    private static final int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String resetPasswordToken;
    private Date expiryDate;
    @OneToOne//colocar cascade dps
    private User user;

    public PasswordToken(String resetPasswordToken, User user) {
        log.info("dsadsadas");
        this.resetPasswordToken = resetPasswordToken;
        this.user = user;
    }

    public PasswordToken() {
        log.info("dsadsadas");
    }
}
