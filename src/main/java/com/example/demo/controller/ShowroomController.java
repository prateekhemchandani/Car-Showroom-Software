package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Showroom;
import com.example.demo.repository.ShowroomRepository;

@RestController
@RequestMapping("/api/showrooms")
public class ShowroomController {

    @Autowired
    private ShowroomRepository showroomRepository;

    // Get all showrooms
    @GetMapping
    public List<Showroom> getAllShowrooms() {
        return showroomRepository.findAll();
    }

    // Create a new showroom
    @PostMapping
    public Showroom createShowroom(@RequestBody Showroom showroom) {
        return showroomRepository.save(showroom);
    }

    // Get showroom by ID
    @GetMapping("/{id}")
    public Showroom getShowroomById(@PathVariable Integer id) {
        return showroomRepository.findById(id).orElse(null);
    }

    // Update showroom
    @PutMapping("/{id}")
    public Showroom updateShowroom(@PathVariable Integer id, @RequestBody Showroom updated) {
        return showroomRepository.findById(id).map(showroom -> {
            showroom.setName(updated.getName());
            showroom.setAddress(updated.getAddress());
            showroom.setManager(updated.getManager());
            showroom.setTotalEmployees(updated.getTotalEmployees());
            showroom.setTotalCars(updated.getTotalCars());
            return showroomRepository.save(showroom);
        }).orElse(null);
    }

    // Delete showroom
    @DeleteMapping("/{id}")
    public String deleteShowroom(@PathVariable Integer id) {
        showroomRepository.deleteById(id);
        return "Showroom deleted with id: " + id;
    }
}
