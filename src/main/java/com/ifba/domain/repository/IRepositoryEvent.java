package com.ifba.domain.repository;

import com.ifba.domain.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryEvent extends JpaRepository<Event,Long> {

}
