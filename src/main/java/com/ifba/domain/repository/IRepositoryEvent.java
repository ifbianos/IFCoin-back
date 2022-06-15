package com.ifba.domain.repository;

import com.ifba.domain.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IRepositoryEvent extends JpaRepository<Event,Long> {

    Optional<Event> findEventByPendingStudentListId(Long id);
    List<Event> findAllByStudentListId(Long id);

}
