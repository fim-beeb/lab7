package com.example.lab7_6733804228_sec3.repository;

import com.example.lab7_6733804228_sec3.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
