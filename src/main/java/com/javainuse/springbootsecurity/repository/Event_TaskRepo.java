package com.javainuse.springbootsecurity.repository;

import com.javainuse.springbootsecurity.model.Association;
import com.javainuse.springbootsecurity.model.Event;
import com.javainuse.springbootsecurity.model.Event_Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface Event_TaskRepo extends JpaRepository<Event_Task, Integer> {
    Event_Task findById(int id);
    List<Event_Task> findAllByEvent(Event event);

}