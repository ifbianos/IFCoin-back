package com.ifba.domain.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Teacher {

    @Id
    private Long id;
    private String name;
    private String cpf;

    @OneToOne
    private Wallet wallet;

    @OneToOne(cascade={CascadeType.ALL})
    private User user;
}


