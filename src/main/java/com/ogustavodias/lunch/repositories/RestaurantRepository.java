package com.ogustavodias.lunch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogustavodias.lunch.models.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
