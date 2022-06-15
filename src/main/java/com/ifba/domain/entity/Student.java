package com.ifba.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Student {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;

    @OneToOne
    private Wallet wallet;


    @OneToOne(cascade={CascadeType.ALL})
    private User user;

    @ManyToMany
    private List<Event> events;
}
