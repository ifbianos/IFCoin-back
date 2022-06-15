package com.ifba.domain.usecase.event;

import com.ifba.application.exception.exceptions.UniversalErro;
import com.ifba.config.enuns.ErroEnum;
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

    public void acceptRequestEvent(Long id){
       Optional<Event> event = iRepositoryEvent.findEventByPendingStudentListId(id);
       if (event.isEmpty()){
           throw new UniversalErro(ErroEnum.STUDENT_IN_NONEXISTENT_EVENT);
       }
       try{
           Optional<Student> student = iRepositoryStudent.findById(id);
           List<Student> studentList = event.get().getStudentList();
           studentList.add(student.get());
           event.get().setStudentList(studentList);
           event.get().getPendingStudentList().remove(student.get());
           iRepositoryEvent.save(event.get());
       }catch(Exception e){
          throw new UniversalErro(ErroEnum.GENERIC_ERROR);
       }
    }

    public List<Event> findAllStudentEvents(Long id){
        return iRepositoryEvent.findAllByStudentListId(id);
    };

    public Event saveEvent(Event event){
        return iRepositoryEvent.save(event);
    };

    public List<Event> findAllEvents(){
        return iRepositoryEvent.findAll();
    };
}
