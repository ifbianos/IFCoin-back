package com.ifba.application.controller.events;


import com.ifba.config.modelmapper.eventconvert.EventConvert;
import com.ifba.domain.dto.event.EventDTO;
import com.ifba.domain.usecase.event.EventUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/event")
public class EventController {

    private final EventConvert eventConvert;
    private final EventUseCase eventUseCase;

    public EventController(EventConvert eventConvert, EventUseCase eventUseCase) {
        this.eventConvert = eventConvert;
        this.eventUseCase = eventUseCase;
    }

    @PostMapping
    public ResponseEntity<EventDTO> saveEvent(@RequestBody EventDTO eventDTO){
        eventUseCase.saveEvent(eventConvert.dtoToEntity(eventDTO));
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(eventDTO)
                .toUri()).body(eventDTO);
    }

    @GetMapping
    public ResponseEntity<List<EventDTO>> getEvents(@RequestBody List<EventDTO> eventDTOList){
        return ResponseEntity.ok().body(eventConvert
                .entityToListDTO(eventUseCase.findAllEvents()));
    }

}
