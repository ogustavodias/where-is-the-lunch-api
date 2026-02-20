package com.ogustavodias.lunch.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogustavodias.lunch.models.Winner;
import com.ogustavodias.lunch.models.Restaurant;

public interface WinnerRepository extends JpaRepository<Winner, Long> {

   boolean existsByWinnerAndDateBetween(Restaurant winner, LocalDate startOfWeek, LocalDate endOfWeek);

}
