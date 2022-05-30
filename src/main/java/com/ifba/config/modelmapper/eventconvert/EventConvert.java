package com.ifba.config.modelmapper.eventconvert;

import com.ifba.config.modelmapper.ModelMapperConfig;
import com.ifba.domain.dto.event.EventDTO;
import com.ifba.domain.dto.requestaccount.RequestAccountDtoIn;
import com.ifba.domain.dto.requestaccount.RequestAccountDtoOut;
import com.ifba.domain.entity.Event;
import com.ifba.domain.entity.RequestAccount;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<EventDTO> entityToListDTO(List<Event> eventList){
        return modelMapperConfig.modelMapper().map(eventList,new TypeToken<List<EventDTO>>() {}.getType());
    }
}
