package com.javainuse.springbootsecurity.repository;

import com.javainuse.springbootsecurity.model.Employee;
import com.javainuse.springbootsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Employee findById(long id);
}