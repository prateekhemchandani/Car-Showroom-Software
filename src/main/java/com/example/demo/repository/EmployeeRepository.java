package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Employee;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Get all employees in a specific showroom
    List<Employee> findByShowroomId(Integer showroomId);
}
