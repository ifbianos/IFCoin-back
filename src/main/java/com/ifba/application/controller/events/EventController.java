package com.ifba.application.controller.events;


import com.ifba.config.modelmapper.eventconvert.EventConvert;
import com.ifba.domain.dto.event.EventDTO;
import com.ifba.domain.dto.event.EventRequestDto;
import com.ifba.domain.entity.Student;
import com.ifba.domain.usecase.event.EventUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/user/event")
public class EventController {

    private final EventConvert eventConvert;
    private final EventUseCase eventUseCase;


    public EventController(EventConvert eventConvert, EventUseCase eventUseCase) {
        this.eventConvert = eventConvert;
        this.eventUseCase = eventUseCase;
    }

    @PostMapping
    public ResponseEntity<EventRequestDto> saveEvent(@RequestBody EventRequestDto eventRequestDto){
        eventUseCase.saveEvent(eventConvert
                .requestDtoToEntity(eventUseCase.addRequestStudentsToEvent(eventRequestDto),eventRequestDto));

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(eventRequestDto)
                .toUri()).body(eventRequestDto);
    }

    @GetMapping
    public ResponseEntity<List<EventRequestDto>> getEvents(){
        return ResponseEntity.ok().body(eventConvert
                .entityToRequestListDTO(eventUseCase.findAllEvents()));
    }

}
