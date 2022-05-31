package com.ifba.domain.usecase.event;

import com.ifba.domain.dto.event.EventRequestDto;
import com.ifba.domain.entity.Event;
import com.ifba.domain.entity.Student;
import com.ifba.domain.repository.IRepositoryEvent;
import com.ifba.domain.repository.IRepositoryStudent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EventUseCase {

    private final IRepositoryEvent iRepositoryEvent;
    private final IRepositoryStudent iRepositoryStudent;

    public EventUseCase(IRepositoryEvent iRepositoryEvent, IRepositoryStudent iRepositoryStudent) {
        this.iRepositoryEvent = iRepositoryEvent;
        this.iRepositoryStudent = iRepositoryStudent;
    }

    public List<Student> addRequestStudentsToEvent(EventRequestDto event){
        List<Student> studentList = new ArrayList<>();
        event.getRequestStudentList().forEach(student ->
                 iRepositoryStudent.findById(student)
                         .ifPresent( s -> studentList.add(iRepositoryStudent.findById(student).get())));
        return studentList;
    }

    public Event saveEvent(Event event){
        return iRepositoryEvent.save(event);
    };

    public List<Event> findAllEvents(){
        return iRepositoryEvent.findAll();
    };
}
