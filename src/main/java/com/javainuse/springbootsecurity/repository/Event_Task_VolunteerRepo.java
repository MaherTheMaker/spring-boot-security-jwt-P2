package com.javainuse.springbootsecurity.repository;

import com.javainuse.springbootsecurity.model.Beneficiary_Event;
import com.javainuse.springbootsecurity.model.Event;
import com.javainuse.springbootsecurity.model.Event_Task;
import com.javainuse.springbootsecurity.model.Event_Task_Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface Event_Task_VolunteerRepo extends JpaRepository<Event_Task_Volunteer, Integer> {
    Event_Task_Volunteer findById(int id);
    List<Event_Task_Volunteer> findAllByEventTask(Event_Task event_task);

}