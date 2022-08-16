package com.javainuse.springbootsecurity.repository;

import com.javainuse.springbootsecurity.model.Beneficiary;
import com.javainuse.springbootsecurity.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BeneficiaryRepo extends JpaRepository<Beneficiary, Long> {
    Beneficiary findById(long id);
}