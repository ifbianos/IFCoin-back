package com.ifba.application.controller.events;


import com.ifba.config.modelmapper.eventconvert.EventConvert;
import com.ifba.domain.dto.event.EventDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("api/event")
public class EventController {

    private final EventConvert eventConvert;

    public EventController(EventConvert eventConvert) {
        this.eventConvert = eventConvert;
    }

    @PostMapping
    public ResponseEntity<EventDTO> saveEvent(@RequestBody EventDTO eventDTO){

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(eventDTO)
                .toUri()).body(eventDTO);
    }
}
