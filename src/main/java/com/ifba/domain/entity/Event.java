package com.ifba.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
public class Event {

    @Id
    private String id;
    private String name;
    private String status;
    private Date startAt;
    private Date finishAt;
    private Integer ifCoins;
    private Date date;
    @OneToMany
    private List<Student> studentList;

}
