package com.ifba.domain.dto.event;

import com.ifba.domain.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EventDTO {

    private String id;
    private String name;
    private String status;
    private Date startAt;
    private Date finishAt;
    private Integer ifCoins;
    private Date date;
    private List<Student> studentList;

}
