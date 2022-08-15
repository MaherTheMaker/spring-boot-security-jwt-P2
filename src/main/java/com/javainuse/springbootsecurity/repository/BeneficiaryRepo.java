package com.javainuse.springbootsecurity.repository;

import com.javainuse.springbootsecurity.model.Beneficiary;
import com.javainuse.springbootsecurity.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BeneficiaryRepo extends JpaRepository<Beneficiary, Integer> {
    Beneficiary findById(Long id);
}