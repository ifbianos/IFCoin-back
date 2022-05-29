package com.ifba.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class Coordinator {

    @Id
    private Long Id;
    private String name;
    private String cpf;

    @OneToOne
    private Wallet wallet;

    @OneToOne(cascade={CascadeType.ALL})
    private User user;
}
