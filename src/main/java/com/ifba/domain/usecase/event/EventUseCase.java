package com.ifba.domain.usecase.event;

import com.ifba.domain.entity.Event;
import com.ifba.domain.repository.IRepositoryEvent;
import org.springframework.stereotype.Service;

@Service
public class EventUseCase {

    private final IRepositoryEvent iRepositoryEvent;

    public EventUseCase(IRepositoryEvent iRepositoryEvent) {
        this.iRepositoryEvent = iRepositoryEvent;
    }

    public Event saveEvent(Event event){
      return iRepositoryEvent.save(event);
    };
}
