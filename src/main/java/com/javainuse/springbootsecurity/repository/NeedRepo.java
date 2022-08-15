package com.javainuse.springbootsecurity.repository;

import com.javainuse.springbootsecurity.model.Event;
import com.javainuse.springbootsecurity.model.Event_Task;
import com.javainuse.springbootsecurity.model.Need;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NeedRepo extends JpaRepository<Need, Integer> {
    Need findById(int id);

}