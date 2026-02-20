package com.ogustavodias.lunch.services;

import org.springframework.stereotype.Service;

import com.ogustavodias.lunch.errors.EntityNotFoundException;
import com.ogustavodias.lunch.models.Restaurant;
import com.ogustavodias.lunch.repositories.RestaurantRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RestaurantService {

   private final RestaurantRepository repository;

   public Restaurant findRestaurant(Long id) {
      String notFoundMessage = String.format("Restaurant with id %s not found", id);
      return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(notFoundMessage));
   }

}
