package com.example.employeepayrollapp.repository;

import com.example.employeepayrollapp.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeModel,Integer> {
}
