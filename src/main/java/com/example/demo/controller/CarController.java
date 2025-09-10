package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    // NEW: Get all cars in a specific showroom
    @GetMapping("/showroom/{showroomId}")
    public List<Car> getCarsByShowroom(@PathVariable Integer showroomId) {
        return carRepository.findByShowroomId(showroomId);
    }
}