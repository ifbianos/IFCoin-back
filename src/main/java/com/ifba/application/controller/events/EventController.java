package com.ifba.application.controller.events;


import com.ifba.config.modelmapper.eventconvert.EventConvert;
import com.ifba.domain.dto.event.EventID;
import com.ifba.domain.dto.event.EventRequestDto;
import com.ifba.domain.usecase.event.EventUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.HashMap;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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


    @PatchMapping("/accept")
    public ResponseEntity<HashMap<String,String>> acceptEvent(@RequestBody EventID eventID){
        eventUseCase.acceptRequestEvent(eventID.getId());
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("msg","aceito com sucesso");
        return ResponseEntity.ok().body(hashMap);
    }

    @GetMapping("/my-events")
    public ResponseEntity<List<EventRequestDto>> listStudentEvents(@RequestBody EventID eventID){
        return ResponseEntity.ok().body(eventConvert
                .entityToRequestListDTO(eventUseCase.findAllStudentEvents(eventID.getId())));
    }

    @GetMapping
    public ResponseEntity<List<EventRequestDto>> getEvents(){
        return ResponseEntity.ok().body(eventConvert
                .entityToRequestListDTO(eventUseCase.findAllEvents()));
    }

}
