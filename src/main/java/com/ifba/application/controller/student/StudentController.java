package com.ifba.application.controller.student;


import com.ifba.domain.dto.event.EventRequestDto;
import com.ifba.domain.entity.Student;
import com.ifba.domain.usecase.student.StudentUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.websocket.server.PathParam;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/user/student")
public class StudentController {

    private final StudentUseCase studentUseCase;

    public StudentController(StudentUseCase studentUseCase) {
        this.studentUseCase = studentUseCase;
    }


    @GetMapping
    public ResponseEntity<List<Student>> findStudentByContainingString(@RequestParam String containing){
        studentUseCase.findStudentByContainingString(containing);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(containing)
                .toUri()).body( studentUseCase.findStudentByContainingString(containing));
    }


}
