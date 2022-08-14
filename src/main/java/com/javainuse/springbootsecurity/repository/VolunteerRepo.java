package com.javainuse.springbootsecurity.repository;

import com.javainuse.springbootsecurity.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VolunteerRepo extends JpaRepository<Volunteer, Integer> {
    Volunteer findById(int id);

}