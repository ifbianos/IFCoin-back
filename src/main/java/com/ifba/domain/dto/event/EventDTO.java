package com.ifba.domain.dto.event;

import com.ifba.domain.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EventDTO {

    private Long id;
    private String name;
    private String status;
    private Date startAt;
    private Date finishAt;
    private Integer ifCoins;
    private List<Student> studentList;

}
