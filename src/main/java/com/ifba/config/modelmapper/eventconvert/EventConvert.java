package com.ifba.config.modelmapper.eventconvert;

import com.ifba.config.modelmapper.ModelMapperConfig;
import com.ifba.domain.dto.event.EventDTO;
import com.ifba.domain.dto.event.EventRequestDto;
import com.ifba.domain.entity.Event;
import com.ifba.domain.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class EventConvert {

   private final ModelMapperConfig modelMapperConfig;

    public EventConvert(ModelMapperConfig modelMapperConfig) {
        this.modelMapperConfig = modelMapperConfig;
    }

    public Event dtoToEntity(EventDTO eventDTO){
        return modelMapperConfig.modelMapper().map(eventDTO, Event.class);
    }

    public EventDTO entityToDto(Event event){
        return modelMapperConfig.modelMapper().map(event,EventDTO.class);
    }

    public List<EventDTO> entityToListDTO(List<Event> eventList){
        return modelMapperConfig.modelMapper().map(eventList,new TypeToken<List<EventDTO>>() {}.getType());
    }





    public Event requestDtoToEntity(List<Student> studentList, EventRequestDto eventRequestDto){
        Event event = modelMapperConfig.modelMapper().map(eventRequestDto, Event.class);
        event.setPendingStudentList(studentList);
        return event;
    }

    public EventRequestDto entityToRequestDto(Event event){
        return modelMapperConfig.modelMapper().map(event,EventRequestDto.class);
    }

    public List<EventRequestDto> entityToRequestListDTO(List<Event> eventList){
        return modelMapperConfig.modelMapper().map(eventList,new TypeToken<List<EventRequestDto>>() {}.getType());
    }
}
