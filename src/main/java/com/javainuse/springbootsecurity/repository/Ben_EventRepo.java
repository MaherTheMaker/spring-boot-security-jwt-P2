package com.javainuse.springbootsecurity.repository;

import com.javainuse.springbootsecurity.model.Beneficiary_Event;
import com.javainuse.springbootsecurity.model.Event;
import com.javainuse.springbootsecurity.model.Event_Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface Ben_EventRepo extends JpaRepository<Beneficiary_Event, Integer> {
    Beneficiary_Event findById(int id);
    List<Beneficiary_Event> findAllByEvent(Event event);

}