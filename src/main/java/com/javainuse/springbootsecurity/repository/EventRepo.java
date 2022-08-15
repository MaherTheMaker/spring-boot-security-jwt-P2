package com.javainuse.springbootsecurity.repository;

import com.javainuse.springbootsecurity.model.Association;
import com.javainuse.springbootsecurity.model.Employee;
import com.javainuse.springbootsecurity.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface EventRepo extends JpaRepository<Event, Integer> {
    Event findById(Long id);
    List<Event> findAllByNameContaining(String name);
    List<Event> findAllByStartingDateBetween(Date start, Date end);
    List<Event> findAllByAssociation(Association association);
    List<Event> findAllByAssociationAndAvailableForRegister(Association association,boolean available);

}