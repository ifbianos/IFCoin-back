package com.ifba.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
public class Event {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status = "Nao iniciado";
    private String description;

    //jsonignore
    private Date startAt; // fazer a logica disso dps

    private Integer ifCoins;
    @ManyToMany
    private List<Student> pendingStudentList;

    @ManyToMany
    private List<Student> studentList;


}
