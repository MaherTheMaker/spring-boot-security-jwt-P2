package com.javainuse.springbootsecurity.repository;

import com.javainuse.springbootsecurity.model.VolunteeringArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VolunteerAreaRepository extends JpaRepository<VolunteeringArea, Long> {


}