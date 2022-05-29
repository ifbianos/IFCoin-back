package com.ifba.config.modelmapper.eventconvert;

import com.ifba.config.modelmapper.ModelMapperConfig;
import com.ifba.domain.dto.event.EventDTO;
import com.ifba.domain.entity.Event;
import org.springframework.stereotype.Service;

@Service
public class EventConvert {

   private final ModelMapperConfig modelMapperConfig;

    public EventConvert(ModelMapperConfig modelMapperConfig) {
        this.modelMapperConfig = modelMapperConfig;
    }

    public Event dtoToEntity(EventDTO eventDTO){
        return modelMapperConfig.modelMapper().map(eventDTO,Event.class);
    }
    public EventDTO entityToDto(Event event){
        return modelMapperConfig.modelMapper().map(event,EventDTO.class);
    }

}
