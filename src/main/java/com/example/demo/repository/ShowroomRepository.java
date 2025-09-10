package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Showroom;

public interface ShowroomRepository extends JpaRepository<Showroom, Integer> {
    // No need to write anything; basic CRUD is ready
}
