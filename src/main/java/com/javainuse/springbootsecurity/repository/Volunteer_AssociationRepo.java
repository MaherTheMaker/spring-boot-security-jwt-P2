package com.javainuse.springbootsecurity.repository;

import com.javainuse.springbootsecurity.model.Association;
import com.javainuse.springbootsecurity.model.Status;
import com.javainuse.springbootsecurity.model.Volunteer;
import com.javainuse.springbootsecurity.model.Volunteer_Association;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Volunteer_AssociationRepo extends JpaRepository<Volunteer_Association, Integer> {
    Volunteer_Association findById(Long id);

    Volunteer_Association findByAssociation(Association association);

    Volunteer_Association findByAssociationAndStatus(Association association, Status status );

}