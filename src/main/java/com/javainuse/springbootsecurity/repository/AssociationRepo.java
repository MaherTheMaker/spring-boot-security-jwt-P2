package com.javainuse.springbootsecurity.repository;

import com.javainuse.springbootsecurity.model.Association;
import com.javainuse.springbootsecurity.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AssociationRepo extends JpaRepository<Association, Integer> {
    Association findById(Long id);
    Association findByName(String name);

}