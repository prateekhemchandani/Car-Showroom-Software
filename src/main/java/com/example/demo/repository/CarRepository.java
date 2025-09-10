package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Car;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    // Get all cars in a specific showroom
    List<Car> findByShowroomId(Integer showroomId);
}
